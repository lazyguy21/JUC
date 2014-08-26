package lazyguy.yyf.base;

/**
 * Created by yeyf on 2014-8-25.
 */
public class BasicThread {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("这句话不会等你发射再打印~");
    }
}
