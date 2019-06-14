package lazyguy.yyf.api.fairUnfair;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by @author yyf on 2019-03-20.
 */
public class ValuableResource {
    private Lock lock;


    public ValuableResource(Boolean fair) {
        this.lock = new ReentrantLock(false);
    }

    public void mockDoSth() {
        lock.lock();
        try {
            System.out.println("threadName "+Thread.currentThread().getName() +" get lock !");
        } finally {
            lock.unlock();

        }
    }
}
