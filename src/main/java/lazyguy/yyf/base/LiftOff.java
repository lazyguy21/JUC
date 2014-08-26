package lazyguy.yyf.base;

/**
 * Created by yeyf on 2014-8-25.
 */
public class LiftOff implements Runnable {
    protected Integer countDown=10;
    private static Integer taskCount=0;
    private final Integer id=taskCount++;

    public LiftOff() {
    }
    public LiftOff(Integer countDown) {
        this.countDown = countDown;
    }

    public String getStatus(){
        return "ID" + id +"("+(countDown>0?countDown:"发射~")+"),  ";

    }
    @Override
    public void run() {
        while(countDown-->0){
            System.out.print(getStatus());
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
        System.out.println("这样子发射没有启动一个线程，所以要等发射完了再打印这句话");
    }
}
