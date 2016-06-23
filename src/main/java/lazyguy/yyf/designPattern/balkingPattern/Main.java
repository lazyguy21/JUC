package lazyguy.yyf.designPattern.balkingPattern;

/**
 * Created by tobi on 16-6-23.
 */
public class Main {
    public static void main(String[] args) {
        Data data = new Data("OftenChangedData");

        new ChangThread("changer", data).start();
        new SaveThread("autoSaver", data).start();


    }
}
