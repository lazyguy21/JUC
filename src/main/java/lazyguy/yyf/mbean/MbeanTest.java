package lazyguy.yyf.mbean;

import org.junit.Test;

import javax.management.MBeanServerFactory;
import java.lang.management.ManagementFactory;
import java.lang.management.MonitorInfo;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by @author yyf on 2019-03-19.
 */
public class MbeanTest {
    @Test
    public void t() throws InterruptedException {
        ReentrantLock lockA = new ReentrantLock();
        ReentrantLock lockB = new ReentrantLock();
        Condition conditionA = lockA.newCondition();
        Condition conditionB = lockB.newCondition();
        Thread a = new Thread(
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
        );
        a.start();

        Thread b = new Thread(
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
        );
        b.start();

        TimeUnit.SECONDS.sleep(10L);

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo threadInfoA = threadMXBean.getThreadInfo(a.getId());

        threadInfoA.getLockedMonitors();
        MonitorInfo[] lockedMonitors = threadInfoA.getLockedMonitors();
        TimeUnit.DAYS.sleep(1L);



    }
}
