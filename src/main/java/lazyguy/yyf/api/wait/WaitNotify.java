package lazyguy.yyf.api.wait;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tobi on 16-6-20.
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();


    static class Wait implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true. wait @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread() + " flag is false. running @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));

            }
        }
    }
}
