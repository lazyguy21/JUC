package lazyguy.yyf.exercise.condition;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    //6.Buffer类，有6个属性：
//
//    一个类型为LinkedList<String>，名为buffer的属性，用来存储共享数据
//    一个类型为int，名为maxSize的属性，用来存储缓冲区的长度
//    一个名为lock的ReentrantLock对象，用来控制修改缓冲区代码块的访问
//    两个名分别为lines和space，类型为Condition的属性
//    一个Boolean类型，名为pendingLines的属性，表明如果缓冲区中有行
    private LinkedList<String> buffer;
    private int maxSize;
    private ReentrantLock lock;
    private Condition lines;
    private Condition space;
    private boolean pendingLines;
//实现Buffer类的构造器，初始化前面描述的所有属性。

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LinkedList<>();
        lock = new ReentrantLock();
        lines = lock.newCondition();
        space = lock.newCondition();
        pendingLines = true;
    }

    public void insert(String line) {
        lock.lock();
        try {
            while (buffer.size() == maxSize) {
                space.await();
            }
            buffer.offer(line);
            System.out.printf("%s: Inserted Line: %d\n", Thread.
                    currentThread().getName(), buffer.size());
            lines.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}