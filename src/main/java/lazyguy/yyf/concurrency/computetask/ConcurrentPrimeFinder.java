package lazyguy.yyf.concurrency.computetask;

/**
 * Created by yeyf on 2014-9-18.
 */
public class ConcurrentPrimeFinder extends AbstractPrimeFinder {
    private final int poolSize;
    private final int numberOfParts;

    public ConcurrentPrimeFinder(final int poolSize,final int numberOfParts) {
        this.poolSize = poolSize;
        this.numberOfParts = numberOfParts;
    }

    @Override
    public int countPrimes(int number) {
        return 0;
    }
}
