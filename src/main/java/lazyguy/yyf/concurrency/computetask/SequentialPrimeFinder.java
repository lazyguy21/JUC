package lazyguy.yyf.concurrency.computetask;

public class SequentialPrimeFinder extends AbstractPrimeFinder {
    public static void main(final String[] args) {
        new SequentialPrimeFinder().timeAndCompute(10000000);
    }

    public int countPrimes(final int number) {
        return countPrimesInRange(1, number);
    }
}