package lazyguy.yyf.threadObject;

public class Test {
    public static void main(String[] args) throws Exception {
        MyThread mt = new MyThread();
        mt.start();
        mt.join();
        System.out.println("我在哪儿？");
    }
}