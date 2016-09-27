package lazyguy.yyf.collection.queue.blockingQueue;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by tobi on 16-9-26.
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityBlockingQueue<PriorityItem> priorityBlockingQueue = new PriorityBlockingQueue<>();
        priorityBlockingQueue.add(new PriorityItem(1));
        priorityBlockingQueue.add(new PriorityItem(0));
        priorityBlockingQueue.add(new PriorityItem(4));
        priorityBlockingQueue.add(new PriorityItem(-1));

        System.out.println(priorityBlockingQueue);
        while (true){
            PriorityItem remove = priorityBlockingQueue.remove();
            System.out.println(remove);
        }
    }
}
