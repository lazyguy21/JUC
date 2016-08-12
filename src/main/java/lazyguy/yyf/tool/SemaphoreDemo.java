package lazyguy.yyf.tool;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by tobi on 16-7-19.
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                if (semaphore.tryAcquire()) {
                    try {
                        System.out.println("I got a permit ,do something!");
                        TimeUnit.SECONDS.sleep(5);
//                        int ex = 1 / 0;// 注意如果try块中做的事抛出了异常，那么semaphore并不会自动release,所以必须将release放在finally里面
//                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
// 注意如果try块中做的事抛出了异常，那么semaphore并不会自动release,所以必须将release放在finally里面
                        semaphore.release();
                    }
                } else {
                    System.out.println("I do not get permit,quit~");
                }
            }).start();
        }
        Runnable runnable = () -> {
            try {
                semaphore.acquire();
                System.out.println("不管等多久，俺最后还是得到了ｐｅｒｍｉｔ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(runnable).start();
    }
}
