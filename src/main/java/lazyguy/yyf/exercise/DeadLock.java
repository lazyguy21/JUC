package lazyguy.yyf.exercise;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tobi on 2017/2/15.
 */
public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lockA = new ReentrantLock();
        ReentrantLock lockB = new ReentrantLock();
        Condition conditionA = lockA.newCondition();
        Condition conditionB = lockB.newCondition();
        new Thread(
                () -> {
                    try {
                        lockA.lock();
                        TimeUnit.SECONDS.sleep(2L);
                        lockB.lock();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lockA.unlock();
                        lockB.unlock();
                    }
                }
        ).start();

        new Thread(
                () -> {
                    try {
                        lockB.lock();
                        TimeUnit.SECONDS.sleep(2L);
                        lockA.lock();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lockA.unlock();
                        lockB.unlock();
                    }
                }
        ).start();
        TimeUnit.DAYS.sleep(1L);
    }
}
