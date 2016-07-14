package lazyguy.yyf.tool.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by tobi on 16-7-8.
 */
public class InvokeAnyDemo {
    public static void main(String[] args) {
        int count = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Task> objects = new ArrayList<>();
        while (count < 10) {
            Task task = new Task();
            objects.add(task);
            count++;
        }
        try {
            Double aDouble = executorService.invokeAny(objects);

            System.out.println(aDouble);
           executorService.shutdown();//不加这句，线程池里面的其他工作线程全是ｗａｉｔｔｉｎｇ到永远
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    static class Task implements Callable<Double> {

        @Override
        public Double call() throws Exception {
            System.out.println("haha");
            long start = System.currentTimeMillis();
            long l = (long) (Math.random() * 100);
            TimeUnit.SECONDS.sleep(l);
            double random = Math.random();
            long end = System.currentTimeMillis();
            System.out.println("睡了　"+l+" 返回了"+random);
            return random;
        }
    }
}

