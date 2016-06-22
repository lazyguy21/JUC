package lazyguy.yyf;

/**
 * Created by tobi on 16-6-22.
 */
public class IllegalMontiorStateExceptionDemo extends Thread {
    Object lock = new Object();

    @Override
    public void run() {
        lock.notify();//IllegalMonitorStateException
    }

    public static void main(String[] args) {
        new IllegalMontiorStateExceptionDemo().start();
    }
}
