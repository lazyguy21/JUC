package lazyguy.yyf.designPattern.consumerPattern;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tobi on 2017/2/6.
 */
public class BoundBuffer3<T> {
    private int size;
    private T[] buffer;

    private int putIndex;
    private int takeIndex;
    private int count;

    private Lock lock = new ReentrantLock();
    Condition putCondition = lock.newCondition();
    Condition takeCondition = lock.newCondition();

    public BoundBuffer3(int size) {
        this.size = size;
        buffer = (T[]) new Object[size];
    }

    public void put(T item){
        lock.lock();
        try {
            while (count>=size){
                putCondition.await();
            }

            buffer[putIndex++] = item;
            putIndex = putIndex % size;

            count++;

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }

    public T take(){
        lock.lock();
        try {
            while (count<=0){
                takeCondition.await();
            }
            T item = buffer[takeIndex];
            buffer[takeIndex]=null;

            takeIndex++;
            takeIndex = takeIndex % size;

            count--;
            return item;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }

    }
}
