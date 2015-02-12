/**
 * Created by yeyf on 2014-8-27.
 */
package lazyguy.yyf.exercise;

/*
写两个线程，一个线程打印 1~52，另一个线程打印字母A-Z。打印顺序为12A34B56C……5152Z。要求用线程间的通信。
        注：分别给两个对象构造一个对象o，数字每打印两个或字母每打印一个就执行o.wait()。
        在o.wait()之前不要忘了写o.notify()。*/
