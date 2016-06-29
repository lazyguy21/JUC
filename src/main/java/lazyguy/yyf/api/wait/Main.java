package lazyguy.yyf.api.wait;

import java.util.ArrayList;

/**
 * Created by tobi on 16-6-28.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(new User());
        arrayList.add("123+asd");
        System.out.println(arrayList);

    }
}
