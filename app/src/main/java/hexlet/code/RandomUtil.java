package hexlet.code;

import java.util.Random;

public class RandomUtil {
    private static final int MIN = 1;
    private static final int MAX = 100;

    private static final Random RANDOM = new Random();

    public static int getInt() {
        return getInt(MIN, MAX);
    }

    public static int getInt(int max) {
        return getInt(0, max);
    }

    public static int getInt(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }
}
