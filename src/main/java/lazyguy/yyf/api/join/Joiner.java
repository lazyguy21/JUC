package lazyguy.yyf.api.join;

public class Joiner extends Thread {
  private Sleeper sleeper; 
  public Joiner(String name, Sleeper sleeper) { 
    super(name); 
    this.sleeper = sleeper; 
    start(); 
  } 
  public void run() { 
   try { 
      sleeper.join(); 
    } catch(InterruptedException e) { 
      System.out.print("Interrupted"); 
    } 
    System.out.print(getName() + " join completed"); 
  } 
} 
 