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

    public static void greeting() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    public static void initQuestion() {
        numOne = RandomUtil.getInt();
        numTwo = RandomUtil.getInt();
        result = calcGCD(numOne, numTwo);
        System.out.println("Question: " + numOne + " " + numTwo);
    }

    public static boolean isRight(String answer) {
        return Integer.valueOf(answer).equals(result);
    }

    public static String rightAnswer() {
        return String.valueOf(result);
    }
}
