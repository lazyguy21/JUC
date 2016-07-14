package lazyguy.yyf.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by tobi on 16-7-12.
 */
public class FutureTaskConstructor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = () -> System.out.println("haha");
        FutureTask whatever = new FutureTask(runnable, "whatever");//这个方法让ｒｕｎｎａｂｌｅ定制返回一个结果
        new Thread(whatever).start();
        Object o = whatever.get();
        System.out.println(o);
    }
}
