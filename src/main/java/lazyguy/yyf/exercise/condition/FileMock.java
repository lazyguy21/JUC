package lazyguy.yyf.exercise.condition;

import java.util.Random;

/**
 * Created by yeyf on 2014-9-5.
 */
public class FileMock {
    private String content[];
    private int index;

    public FileMock(int size, int length) {
        content = new String[size];
        for (int i = 0; i < size; i++) {
            StringBuilder strBuild = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                int temp = new Random().nextInt(256);
                strBuild.append((char) temp);
            }
            content[i]=strBuild.toString();
        }

        index=0;
    }
    public boolean hasMoreLines(){
        return index<content.length;
    }
    public String getLine(){
        if (hasMoreLines()) {
            System.out.println("Mock: "+(content.length-index));
            return content[index++];
        }
        return null;
    }

}
