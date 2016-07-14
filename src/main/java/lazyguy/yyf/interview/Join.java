package lazyguy.yyf.interview;

/**
 * Created by tobi on 16-7-1.
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {

        Thread a = new Thread() {
            @Override
            public void run() {
                System.out.println("t1 done");
            }
        };
        Thread b = new Thread() {
            @Override
            public void run() {
                try {
                    a.join();
                    System.out.println("t2 done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        Thread c = new Thread() {
            @Override
            public void run() {
                try {
                    b.join();
                    System.out.println("t3 done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        a.start();
        b.start();
        c.start();


        c.join();





    }
}


