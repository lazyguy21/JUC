import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by @author yyf on 2019-03-14.
 */
public class ThreadStateTest {
    @Test
    public void newState() {
        Thread thread = new Thread();
        System.out.println(thread.getState());
    }

    @Test
    public void runnableState() {
        new Thread(() -> {
            System.out.println("current thread state when doing sth : " + Thread.currentThread().getState());
        }).start();
    }

    @Test
    public void BlockedState() throws InterruptedException {
        Object lock = new Object();
        //启动一个线程获取锁，然后假装很忙，再也不放手
        new Thread(() -> {
            synchronized (lock) {
                while (true) {
                }
            }
        }).start();

        Thread threadB = new Thread(() -> {
            synchronized (lock) {
                System.out.println("lock acquired!");
            }
        });
        threadB.start();//线程开始后，状态变成RUNNABLE
        TimeUnit.SECONDS.sleep(5L);//让主线程在这暂停5S，此时B线程已经开始执行，尝试去获取锁，当然是获取不到的
        System.out.println(threadB.getState());//BLOCKED
    }

    @Test
    public void WaitedState() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                new ValuableResource().doSthWaiting();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        //线程启动后，尝试去调用资源的doSthWaiting方法，
        //此方法的逻辑是进来占用了锁的线程，会立即被锁告知请放开我，去门外等一等，
        // 所以这个线程最后会变成WAITING状态
        thread.start();
        TimeUnit.SECONDS.sleep(5L);//当前线程先等一下，让我们的目标线程充分运行

        System.out.println(thread.getState());//WAITING
    }

    @Test
    public void timedWaitingState() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                new ValuableResource().doSthTimedWaiting();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(2L);

        System.out.println(thread.getState());//TIMED_WAITING
        TimeUnit.SECONDS.sleep(2L);
        System.out.println(thread.getState());//RUNNABLE
    }

    /**
     * 线程A先获取到锁，然后睡觉
     * 线程B尝试去获取锁，会处于BOLOCKED状态证明了sleep并不会影响线程对锁的占用，该咋地还是咋的
     */
    @Test
    public void sleepLock() {
        Object lock = new Object();
        Thread threadA = new Thread(() -> {
            synchronized (lock) {
                try {
                    TimeUnit.SECONDS.sleep(100000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
        System.out.println("thread a start");
        Thread threadB = new Thread(() -> {
            synchronized (lock) {
                System.out.println("do stm");
            }
        });
        threadB.start();
        System.out.println("thread b start");
        System.out.println("thread b state: "+threadB.getState());
    }



    private class ValuableResource {
        private Object lock = new Object();

        /***
         * 线程获取到锁后，锁调用自己的wait方法向当前捏着自己的线程说，放开我，你去等着
         * 线程就会变成WAITING，注意这里的线程同时也会放弃锁的使用权
         * @throws InterruptedException
         */
        public void doSthWaiting() throws InterruptedException {
            synchronized (lock) {
                lock.wait();
            }

        }

        public void doSthTimedWaiting() throws InterruptedException {
            synchronized (lock) {
                lock.wait(3000L);
                while (true) {

                }
            }

        }
    }
}
