package lazyguy.yyf.threadObject;

/**
 * Created by yeyf on 2014-8-26.
 */
public class MyThread extends Thread {
       private int x=0;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(x++);
        }
        System.out.println("\n");
    }
}
