package lazyguy.yyf.tool.executors;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by tobi on 16-6-29.
 */
public class ThreadExecutorServiceDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
//        threadPoolExecutor.prestartAllCoreThreads();
        System.out.println(threadPoolExecutor.prestartCoreThread());

    }
}
