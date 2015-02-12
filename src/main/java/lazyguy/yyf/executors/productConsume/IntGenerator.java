package lazyguy.yyf.executors.productConsume;

/**
 * Created by yeyf on 2014-8-28.
 */
public abstract class IntGenerator {
    private volatile boolean canceled=false;
    public abstract int next();
    public void cancel(){
        this.canceled=true;
    }
    public boolean isCanceled(){
        return canceled;
    }
}
