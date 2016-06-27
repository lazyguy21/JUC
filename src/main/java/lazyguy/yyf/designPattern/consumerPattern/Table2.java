package lazyguy.yyf.designPattern.consumerPattern;

import java.util.LinkedList;

/**
 * Created by tobi on 16-6-23.
 */
public class Table2 {
    private final Integer CAPACITY;
    private final LinkedList<String> buffer;

    public Table2(Integer CAPACITY) {
        this.CAPACITY = CAPACITY;
        buffer = new LinkedList<>();
    }

    public synchronized void put(String cake){
        while (buffer.size()>=CAPACITY){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        buffer.

    }
    public synchronized void take(){

    }


}
