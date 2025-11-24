package hexlet.code.game;

import hexlet.code.RandomUtil;

public class GCDGame {
    private static int numOne;
    private static int numTwo;
    private static int result;

    private static int calcGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static String greeting() {
        return "Find the greatest common divisor of given numbers.";
    }

    public static String initQuestion() {
        numOne = RandomUtil.getInt();
        numTwo = RandomUtil.getInt();
        result = calcGCD(numOne, numTwo);
        return "Question: " + numOne + " " + numTwo;
    }

    public static boolean isRight(String answer) {
        return Integer.valueOf(answer).equals(result);
    }

    public static String rightAnswer() {
        return String.valueOf(result);
    }
}
