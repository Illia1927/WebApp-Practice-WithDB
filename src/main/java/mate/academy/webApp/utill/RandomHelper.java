package mate.academy.webApp.utill;

import java.nio.charset.Charset;
import java.util.Random;

public class RandomHelper {
    public static String getRandomCode() {
        Random random = new Random();
        String randomCode = String
                .valueOf(random.nextInt(9999 - 1000 + 1) + 1000);
        return randomCode;
    }

    public static String getRandomSalt() {
        byte[] array = new byte[6];
        new Random().nextBytes(array);

        return new String(array, Charset.forName("UTF-8"));
    }
}
