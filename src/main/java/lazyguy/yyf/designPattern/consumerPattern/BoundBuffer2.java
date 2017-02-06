package lazyguy.yyf.designPattern.consumerPattern;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tobi on 2017/2/6.
 */
public class BoundBuffer2 {
    private int size;
    private Object[] buffer = new Object[size];
    private int putIndex;
    private int takeIndex;
    private int count;

    private ReentrantLock lock = new ReentrantLock();
    private Condition putCondition = lock.newCondition();
    private Condition takeCondition = lock.newCondition();

    public BoundBuffer2(int size) {
        this.size = size;
    }

    public void put(Object item) {
        lock.lock();
        try {
            while (true) {
                if (count < size) {
                    buffer[putIndex] = item;

                    ++putIndex;
                    if (putIndex == size) {
                        putIndex = 0;
                    }
                    break;
                } else {
                    putCondition.await();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void take(Object item) {
        lock.lock();
        try {
            while (true) {
                if (count > 0) {
                    buffer[takeIndex] = item;
                    ++takeIndex;
                    if(takeIndex==size){
                        takeIndex = 0;
                    }
                    break;
                }else {
                    takeCondition.await();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
