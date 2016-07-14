package lazyguy.yyf.api;

/**
 * Created by tobi on 16-7-14.
 */
public class ExceptionInRunnableTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            long id = Thread.currentThread().getId();
            System.out.println(id);
            int i = 3 / 0;

        });
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                long id = Thread.currentThread().getId();
                System.out.println(id);
                System.out.println(e);
            }
        });
        thread.start();
    }
}
