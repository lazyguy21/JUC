package lazyguy.yyf.tool.executors;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by tobi on 2017/2/13.
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,10,10L, TimeUnit.SECONDS,new SynchronousQueue<>(),threadFactory);
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("some work go go go !");
            }
         });

    }
}
