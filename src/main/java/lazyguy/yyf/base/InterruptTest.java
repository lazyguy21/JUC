package lazyguy.yyf.base;

import java.util.concurrent.TimeUnit;

/**
 * Created by tobi on 2017/1/25.
 * 如何中断线程
 */
public class InterruptTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("睡5s");
            }
        });

        thread.start();

        thread.interrupt();
        System.out.println(thread.isInterrupted());
        System.out.println(thread.isInterrupted());
        System.out.println(thread.isInterrupted());
        System.out.println(thread.isInterrupted());
        System.out.println(Thread.interrupted());
    }
}
