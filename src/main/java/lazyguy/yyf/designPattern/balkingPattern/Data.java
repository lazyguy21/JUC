package lazyguy.yyf.designPattern.balkingPattern;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by tobi on 16-6-23.
 */
public class Data {
    private final String fileName;//文件名
    private String content;//文件内容
    private boolean changed;   //表示修改后尚未保存

    public Data(String fileName) {
        this.fileName = fileName;
    }

    public synchronized void change(String content){
        this.content = content;
        this.changed = true;
    }

    public synchronized void save() {
        if (changed) {
            System.out.println(Thread.currentThread().getName()+" start auto save :"+content);
            doSave();
        }
    }
    private void doSave(){

        try(FileWriter fileWriter=new FileWriter(fileName)){
            fileWriter.write(content);
            changed = false;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
