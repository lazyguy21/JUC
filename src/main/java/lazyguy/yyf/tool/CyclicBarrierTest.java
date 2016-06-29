package lazyguy.yyf.tool;

import java.util.concurrent.*;

/**
 * Created by tobi on 16-6-29.
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.println(Thread.currentThread().getName() + " do someThing before all because of it's the last arrival"));
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(new Runner(cyclicBarrier));
        executor.submit(new Runner(cyclicBarrier));
        executor.submit(new Runner(cyclicBarrier));

    }

}

class Runner implements Runnable {
    CyclicBarrier cyclicBarrier;

    public Runner(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        try {
            while (true) {
                TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
                System.out.println(Thread.currentThread().getName() + " has ready for run");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " running!!!!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }


    }
}
