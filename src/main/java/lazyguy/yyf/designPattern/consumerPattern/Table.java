package lazyguy.yyf.designPattern.consumerPattern;

/**
 * Created by tobi on 16-6-23.
 */
public class Table {
    private final String[] buffer;
    private int head;//下一个take的位置
    private int tail;//下一个put的位置
    private int count;//buffer内的蛋糕数量

    public Table(Integer capacity) {
        this.buffer = new String[capacity];

    }

    public synchronized void put(String cake) {
        while(count>=buffer.length){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        System.out.println(Thread.currentThread().getName()+"put in cake : "+cake);
        notifyAll();

    }
    public synchronized String take(){
        while (count <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        System.out.println(Thread.currentThread().getName()+"eat cake : "+cake);
        notifyAll();
        return cake;
    }


}
