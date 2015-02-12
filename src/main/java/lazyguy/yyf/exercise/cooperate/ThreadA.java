package lazyguy.yyf.exercise.cooperate;

/**
 * Created by yeyf on 2014-8-28.
 */
public class ThreadA extends Thread {
   private PrintObject printObject;

    public PrintObject getPrintObject() {
        return printObject;
    }

    public void setPrintObject(PrintObject printObject) {
        this.printObject = printObject;
    }

    @Override
    public void run() {
        printObject.printNum();
    }
}
