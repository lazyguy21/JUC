package lazyguy.yyf.tool;

import java.util.concurrent.CountDownLatch;

/**
 * Created by tobi on 16-6-29.
 */
public class CountDownLatchTest {
   static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep((long) (Math.random() * 10 * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "has finished work !");
                countDownLatch.countDown();
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        countDownLatch.await();
        System.out.println(countDownLatch.getCount());
    }
}
