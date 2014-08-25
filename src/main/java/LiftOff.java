/**
 * Created by yeyf on 2014-8-25.
 */
public class LiftOff implements Runnable {
    private Integer countDown=10;
    private static Integer taskCount=0;
    private final Integer id=taskCount++;

    public LiftOff() {
    }
    public LiftOff(Integer countDown) {
        this.countDown = countDown;
    }

    public String getStatus(){
        return "#" + id +"发射倒计时: "+(countDown>0?countDown:"发射~");

    }
    @Override
    public void run() {
        while(countDown-->0){
            System.out.println(getStatus());
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
