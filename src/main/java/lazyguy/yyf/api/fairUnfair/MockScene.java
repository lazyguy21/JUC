package lazyguy.yyf.api.fairUnfair;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by @author yyf on 2019-03-20.
 */
public class MockScene {
    public static void main(String[] args) throws InterruptedException {
        ValuableResource resource = new ValuableResource(true);
        Runnable runnable = () -> {
            System.out.println("threadName "+Thread.currentThread().getName() +" start !");
            resource.mockDoSth();
        };
        Thread[] threadArray = new Thread[10];
        for (int i=0; i<10; i++) {
            threadArray[i] = new Thread(runnable);
        }
        for (int i=0; i<10; i++) {
            threadArray[i].start();
        }
        TimeUnit.HOURS.sleep(1L);
    }
}
