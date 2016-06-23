package lazyguy.yyf.designPattern.critialRegion;

/**
 * Created by tobi on 16-6-22.
 */
public class MainContainer {
    public static void main(String[] args) {
//        NotThreadSafeGate gate = new NotThreadSafeGate();
        Gate gate = new ThreadSafeGate();
        new UserThread("Alice", "Alaska", gate).start();
        new UserThread("Bobby", "Brazil", gate).start();
        new UserThread("Chris", "Canada", gate).start();
    }
}
