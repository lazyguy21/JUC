package lazyguy.yyf.exercise.cooperate;

/**
 * Created by yeyf on 2014-8-28.
 */
public class PrintObject {
    private Integer num=1;
    public synchronized void printNum(){
        while(num%5!=0){
            System.out.println(num++);
        }
        notifyAll();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
