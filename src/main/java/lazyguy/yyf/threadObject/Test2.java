package lazyguy.yyf.threadObject;

/**
 * Created by yeyf on 2014-8-26.
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        MyThread mt = new MyThread();
        mt.start();
        mt.join();
        Thread.sleep(3000);
        mt.start();
    }
}
