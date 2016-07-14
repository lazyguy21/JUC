package lazyguy.yyf.tool;

import java.util.concurrent.*;

/**
 * Created by tobi on 16-7-12.
 */
public class CaculateCollect {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        Callable<Double> callable = new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                double v = Math.random() * 10;
                //模拟计算耗时
                TimeUnit.SECONDS.sleep((long) v);
                countDownLatch.countDown();
                System.out.println(v);
                return v;
            }
        };
        FutureTask<Double> futureTask = new FutureTask<>(callable);
        FutureTask<Double> futureTask2 = new FutureTask<>(callable);

        new Thread(futureTask).start();
        new Thread(futureTask2).start();
        countDownLatch.await();
        try {
            Double aDouble = futureTask.get();
            Double aDouble1 = futureTask2.get();
            System.out.println(aDouble+aDouble1);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
