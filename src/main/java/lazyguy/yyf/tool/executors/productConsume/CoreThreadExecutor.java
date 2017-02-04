package lazyguy.yyf.tool.executors.productConsume;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by tobi on 2017/2/3.
 */
public class CoreThreadExecutor {
    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(1);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 60L, TimeUnit.MINUTES, arrayBlockingQueue);
        threadPoolExecutor.prestartAllCoreThreads();

    }
}
