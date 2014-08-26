package lazyguy.yyf.executors;

import lazyguy.yyf.base.LiftOff;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yeyf on 2014-8-25.
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
