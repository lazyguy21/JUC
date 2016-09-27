package lazyguy.yyf.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by tobi on 16-9-27.
 */
public class FutureTaskForCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Long> futureTask = new FutureTask<>(() -> {
            long result = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(result);//假装工作一会
            return result;
        });
        new Thread(futureTask).start();

        System.out.println(futureTask.isDone());
        Long result = futureTask.get();
        System.out.println(result);
        System.out.println(futureTask.isDone());
    }
}
