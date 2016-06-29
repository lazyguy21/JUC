package lazyguy.yyf.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tobi on 16-6-29.
 */
public class AtomicIntegerMain {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(1);
        int andIncrement = ai.getAndIncrement();
        System.out.println(andIncrement);
        System.out.println(ai.get());
        int i = ai.incrementAndGet();
        System.out.println(i);
        System.out.println(ai.get());
    }
}
