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
        System.out.println(thread.getState());//刚创建的时候就是new，此时还没有start
        thread.start();
        System.out.println(thread.getState());//刚创建的时候就是new，此时还没有start
        TimeUnit.SECONDS.sleep(1);
        System.out.println(thread.getState());//刚创建的时候就是new，此时还没有start
    }

}
