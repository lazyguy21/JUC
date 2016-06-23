package lazyguy.yyf.designPattern.deadLock;

/**
 * Created by tobi on 16-6-22.
 */
public class Tool {
    private final String name;

    public Tool(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "tool ： "+ name;
    }
}
