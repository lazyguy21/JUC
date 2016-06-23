package lazyguy.yyf.designPattern.consumerPattern;

/**
 * Created by tobi on 16-6-23.
 */
public class Main {
    public static void main(String[] args) {
        Table table = new Table(3);
        new ProduceThread("baker1", table).start();
        new ProduceThread("baker2", table).start();

        new ConsumerThread("eater1", table).start();

    }
}
