package lazyguy.yyf.tool.executors.productConsume;

public class MyThread extends Thread
{
    private String value1;
    private String value2;

    public void run()
    {
        value1 = "通过成员变量返回数据";
        value2 = "通过成员方法返回数据";
    }
    public static void main(String[] args) throws Exception
    {
        MyThread thread = new MyThread();
        thread.start();
        System.out.println("value1:" + thread.value1);
        System.out.println("value2:" + thread.value2);
    }
}