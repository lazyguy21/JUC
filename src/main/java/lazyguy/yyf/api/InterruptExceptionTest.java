package lazyguy.yyf.api;

import java.util.concurrent.TimeUnit;

/**
 * Created by tobi on 16-7-14.
 */
public class InterruptExceptionTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("gogogogogo!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //这个ｔｈｒｅａｄ将一直ＧＧＧ下去，因为ｔｒｙ块在ｗｈｉｌｅ里面，而抛出异常后，Ｉｎｔｅｒｒｕｐｔ这个状态就被重置了。
//                    所以当外层的ｗｈｉｌｅ检查interrupt状态时，又变为了ｆａｌｓｅ，所以又会接着跑下去
//                    这个类似于Thread.interupted()这个方法的含义
//                    所以要再次重设置interrupt状态
//                    Thread.currentThread().interrupt();
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();



    }
}
