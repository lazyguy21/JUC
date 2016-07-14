package lazyguy.yyf.api;

import java.util.concurrent.TimeUnit;

/**
 * Created by tobi on 16-7-14.
 */
public class ThreadStateTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread().getState());
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread.State state = thread.getState();
        System.out.println("state when sleep :"+state);
    }
}
