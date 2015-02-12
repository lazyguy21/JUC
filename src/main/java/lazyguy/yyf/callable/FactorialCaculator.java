package lazyguy.yyf.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by yeyf on 2014-9-10.
 */
public class FactorialCaculator implements Callable<Integer> {
    private Integer number;

    public FactorialCaculator(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int result;
        if (number==0||number==1){
            result=1;
        }else{
            result=1;
            for (int i = 2; i <number ; i++) {
                result = result * i;
            }
        }
        TimeUnit.MILLISECONDS.sleep(20);
        System.out.printf("%s: %d\n",Thread.currentThread().getName(),result);
        return result;
    }
}
