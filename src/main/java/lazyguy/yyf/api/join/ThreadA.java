package lazyguy.yyf.api.join;

import java.util.concurrent.TimeUnit;

/**
 * Created by tobi on 16-11-11.
 */
public class ThreadA extends Thread {
    @Override
    public synchronized void start() {

        try {
            System.out.println("线程A，开始工作!");
            TimeUnit.SECONDS.sleep(10);
            System.out.println("线程A，结束工作！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("haha");
        ThreadA threadA = new ThreadA();

        threadA.start();

        threadA.join();

        System.out.println("heih");

    }
}
