package lazyguy.yyf.executors;

import lazyguy.yyf.base.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yeyf on 2014-8-25.
 */
public class SingleThreadExecutor {
  public static void main(String[] args) { 
    ExecutorService exec =
      Executors.newSingleThreadExecutor();
    for(int i = 0; i < 5; i++)
      exec.execute(new LiftOff());
    exec.shutdown(); 
  } 
}