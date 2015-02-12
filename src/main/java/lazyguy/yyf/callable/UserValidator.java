package lazyguy.yyf.callable;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by yeyf on 2014-9-10.
 */
public class UserValidator {
    private String name;

    public UserValidator(String name) {
        this.name = name;
    }
    public boolean validate(String name ,String password) {
        Random random = new Random();
        try {
            int duration = random.nextInt(10);
            System.out.printf("Validator %s: Validating a user during %d seconds\n", this.name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            return false;
        }
        return random.nextBoolean();
    }

    public String getName() {
        return name;
    }
}
