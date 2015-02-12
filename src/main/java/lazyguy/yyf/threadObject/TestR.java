package lazyguy.yyf.threadObject;

/**
 * Created by yeyf on 2014-8-26.
 */
public class TestR {
    //    public static void main(String[] args) throws Exception {
//        new Thread(new R()).start();
//    }
    public static void main(String[] args) throws Exception {
        R r = new R();
        for (int i = 0; i < 10; i++)
            new Thread(r).start();
    }
}
