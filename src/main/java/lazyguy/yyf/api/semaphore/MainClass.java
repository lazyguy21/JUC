package lazyguy.yyf.api.semaphore;

/**
 * Created by yeyf on 2014-9-5.
 */
public class MainClass {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue(1);
        Job job = new Job(printQueue);

        Thread thread[]=new Thread[10];
        for (int i=0; i<10; i++){
            thread[i]=new Thread(new Job(printQueue),"Thread"+i);
        }
        for (int i=0; i<10; i++){
            thread[i].start();
        }

    }
}
