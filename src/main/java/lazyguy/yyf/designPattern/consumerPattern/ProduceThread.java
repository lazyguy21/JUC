package lazyguy.yyf.designPattern.consumerPattern;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by tobi on 16-6-23.
 */
public class ProduceThread extends Thread {
    private final Table table;
    public ProduceThread(String name,Table table) {
        super(name);
        this.table = table;
    }

    @Override
    public void run() {
        int i =0;
        Random random = new Random();
        while(true){
            table.put("cakeFrom"+this.getName()+"_"+(++i));
            try {
                TimeUnit.SECONDS.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
