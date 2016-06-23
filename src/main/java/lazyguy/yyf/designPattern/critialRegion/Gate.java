package lazyguy.yyf.designPattern.critialRegion;

/**
 * Created by tobi on 16-6-22.
 */
public abstract class Gate {
     int count = 0;
     String name = "Nobody";
     String address = "Nowhere";

    public abstract void pass(String name, String address);
}
