package lazyguy.yyf.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * Created by tobi on 16-7-8.
 */
public class ExchangerDemo {

    public static void main(String[] args) throws InterruptedException {
        Exchanger exchanger = new Exchanger();
        new Thread() {

            @Override
            public void run() {
                while (true) {
                    try {
                        double result = Math.random();
                        Object exchange = exchanger.exchange(result);
                        String name = Thread.currentThread().getName();
                        System.out.println(name+" 放入 " + result+"　得到　"+exchange);
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        System.out.println();
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        double result = Math.random();
                        Object exchange = exchanger.exchange(result);
                        String name = Thread.currentThread().getName();
                        System.out.println(name+" 放入 " + result+"　得到　"+exchange);
                        TimeUnit.SECONDS.sleep(2);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        Thread.sleep(11111111L);
    }
}
