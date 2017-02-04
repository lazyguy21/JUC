package lazyguy.yyf.base;

import java.util.concurrent.TimeUnit;

/**
 * Created by tobi on 16-6-13.
 */
public class ThreadState {
    public static void main(String[] args) {
        Thread timeWaitingThread = new Thread(new TimeWaiting(), "TimeWaitingThread");
        timeWaitingThread.start();
        Thread waitingThread = new Thread(new Waiting(), "WaitingThread");
        waitingThread.start();

        Thread thread = new Thread(new Blocked(), "BlockedThread-1");
        thread.start();
        Thread thread1 = new Thread(new Blocked(), "BlockedThread-2");
        thread1.start();
        System.out.println(timeWaitingThread.getState());
        System.out.println(waitingThread.getState());
        System.out.println(thread.getState());

        System.out.println(thread1.getState());
    }


    static class TimeWaiting implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Waiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Blocked implements Runnable {
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

