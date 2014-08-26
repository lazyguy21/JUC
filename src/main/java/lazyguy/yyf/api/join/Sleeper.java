package lazyguy.yyf.api.join;

public class Sleeper extends Thread {
  private int duration; 
  public Sleeper(String name, int sleepTime) { 
    super(name); 
    duration = sleepTime; 
    start(); 
  } 
  public void run() { 
    try { 
      sleep(duration); 
    } catch(InterruptedException e) { 
      System.out.print(getName() + " was interrupted. " + 
        "isInterrupted(): " + isInterrupted()); 
      return; 
    } 
    System.out.print(getName() + " has awakened"); 
  } 
} 
 