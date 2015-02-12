package lazyguy.yyf.api.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by yeyf on 2014-9-5.
 */
public class PrintQueue {
    private Semaphore semaphore=null;

    public PrintQueue(int concurrentNum) {
        semaphore = new Semaphore(concurrentNum);
    }
    public void printJob(Object document){
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " start its print job……");
            Long sleepingTime=(long) (Math.random()*10);
            TimeUnit.SECONDS.sleep(sleepingTime);
            System.out.println(Thread.currentThread().getName() + " finished print job in " + sleepingTime + " seconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }
}
