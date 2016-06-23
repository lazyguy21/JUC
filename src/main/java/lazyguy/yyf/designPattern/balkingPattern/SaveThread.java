package lazyguy.yyf.designPattern.balkingPattern;

import java.util.concurrent.TimeUnit;

/**
 * Created by tobi on 16-6-23.
 */
public class SaveThread extends Thread {
    private final Data data;
    public SaveThread(String name,Data data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        while(true){
            data.save();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
