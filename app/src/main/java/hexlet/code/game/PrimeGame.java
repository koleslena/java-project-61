package hexlet.code.game;

import hexlet.code.RandomUtil;

public class PrimeGame {
    private static final String NO = "no";
    private static final String YES = "yes";

    private static int number;

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String greeting() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    public static String initQuestion() {
        number = RandomUtil.getInt();
        return "Question: " + number;
    }

    public static boolean isRight(String answer) {
        boolean prime = isPrime(number);
        return prime == YES.equals(answer);
    }

    public static String rightAnswer() {
        return isPrime(number) ? YES : NO;
    }
}
