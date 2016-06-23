package lazyguy.yyf.designPattern.balkingPattern;

import java.util.concurrent.TimeUnit;

/**
 * Created by tobi on 16-6-23.
 */
public class ChangThread extends Thread {
    private final Data data;
    public ChangThread(String name,Data data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; true; i++) {
            data.change("content" + i);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.save();

        }
    }
}
