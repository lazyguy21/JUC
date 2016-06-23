package lazyguy.yyf.designPattern.deadLock;

import java.util.concurrent.TimeUnit;

/**
 * Created by tobi on 16-6-22.
 */
public class CustomThread extends Thread {
    private final String name;
    private final Tool leftHandTool;
    private final Tool rightHandTool;


    public CustomThread(String name,Tool leftHandTool,Tool rightHandTool) {
        this.name = name;
        this.leftHandTool = leftHandTool;
        this.rightHandTool = rightHandTool;
    }

    @Override
    public void run() {
        while(true){
            eat();
        }
    }

    private void eat() {
        synchronized (leftHandTool){
            System.out.println(name +" take up "+leftHandTool);

            synchronized (rightHandTool){
                System.out.println(name+ " take up "+rightHandTool);
                System.out.println(name+" start eating !");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name+" put down "+rightHandTool);
            }
            System.out.println(name+" put down "+leftHandTool);
        }
    }
}
