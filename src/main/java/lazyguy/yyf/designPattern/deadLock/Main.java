package lazyguy.yyf.designPattern.deadLock;

/**
 * Created by tobi on 16-6-22.
 */
public class Main {
    public static void main(String[] args) {
        Tool fork = new Tool("fork");
        Tool knife = new Tool("knife");

        new CustomThread("Tobi", fork, knife).start();
        new CustomThread("Alice",knife,fork).start();
    }
}
