package lazyguy.yyf.api;

import lazyguy.yyf.base.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by yeyf on 2014-8-25.
 */
public class SleepingTask extends LiftOff {
    private Long milliseconds = 100L;


    public void setSleepTime(Long milliseconds) {
        this.milliseconds = milliseconds;
    }

    public void run() {
        try {
            while (countDown-- > 0) {
                System.out.print(getStatus());
                // Old-style:
                // Thread.sleep(100);
                // Java SE5/6-style:
                TimeUnit.MILLISECONDS.sleep(milliseconds);
            }
        } catch (InterruptedException e) {
            System.err.println("Interrupted");
        }
    }
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                SleepingTask sleepingTask = new SleepingTask();
                sleepingTask.setSleepTime(10000L);
                exec.execute(sleepingTask);
            } else {
                exec.execute(new SleepingTask());
            }
        }
        exec.shutdown();
    }

}
