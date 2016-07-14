package lazyguy.yyf.designPattern.consumerPattern;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tobi on 16-7-1.
 */
public class BoundBuffer {
    private Object[] buffer = new Object[100];
    private Lock lock = new ReentrantLock();
    Condition takeCondition = lock.newCondition();
    Condition putCondition = lock.newCondition();

    int putptr, takeptr, count;

    public Object take() throws InterruptedException {
        while (count<0){
                takeCondition.await();
        }
        lock.lock();
        try{
            Object result= buffer[takeptr++];
            takeptr = takeptr % 100;
            count -= 1;
            putCondition.notify();
            return result;
        }finally {
            lock.unlock();
        }

    }

    public void put(Object object) throws InterruptedException {
        while(count==buffer.length) putCondition.wait();
        lock.lock();
        buffer[putptr++] = object;
        putptr = putptr % 100;//更新放入的位置

        count += 1;

        takeCondition.notify();
        lock.unlock();

    }

}
