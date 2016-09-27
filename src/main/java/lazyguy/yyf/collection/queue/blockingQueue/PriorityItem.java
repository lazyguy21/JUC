package lazyguy.yyf.collection.queue.blockingQueue;

/**
 * Created by tobi on 16-9-26.
 */
public class PriorityItem implements Comparable<PriorityItem> {
    private Integer priority;

    public PriorityItem(Integer priority) {
        this.priority = priority;
    }

    public Integer getPriority() {
        return priority;
    }

    public PriorityItem setPriority(Integer priority) {
        this.priority = priority;
        return this;
    }

    @Override
    public String toString() {
        return "PriorityItem{" +
                "priority=" + priority +
                '}';
    }

    @Override
    public int compareTo(PriorityItem o) {
        Integer priority = o.getPriority();
        if (this.priority > priority) {
            return 1;
        } else if (this.priority < priority) {
            return -1;
        }
        return 0;
    }
}
