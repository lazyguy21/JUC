package lazyguy.yyf.exercise.productorconsumer;

/**
 * Created by yeyf on 2014-9-11.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    // Allow this to be canceled:
    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
} ///:~
