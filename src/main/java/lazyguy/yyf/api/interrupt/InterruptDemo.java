package lazyguy.yyf.api.interrupt;

import java.util.concurrent.TimeUnit;

public class InterruptDemo {
  public static void main(String[] args) throws InterruptedException {
    Thread busyThread = new Thread(new BusyRunner());
    Thread sleepThread = new Thread(new SleepRunner());
    busyThread.start();
    sleepThread.start();
    TimeUnit.SECONDS.sleep(5);
    busyThread.interrupt();
    sleepThread.interrupt();

    System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
    System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());

    TimeUnit.SECONDS.sleep(5);

    Thread.currentThread().interrupt();
    System.out.println(Thread.currentThread().isInterrupted());
    System.out.println(Thread.interrupted());
    System.out.println(Thread.interrupted());
  }

  static class BusyRunner implements Runnable {
    @Override
    public void run() {
      while (true) {

      }
    }
  }

  static class SleepRunner implements Runnable {
    @Override
    public void run() {
      try {
        TimeUnit.SECONDS.sleep(1000L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
