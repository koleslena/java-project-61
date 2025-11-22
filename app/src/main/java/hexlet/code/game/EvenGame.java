package hexlet.code.game;

import hexlet.code.RandomUtil;

public class EvenGame {

    private static final String NO = "no";
    private static final String YES = "yes";

    private static int num;

    public static void initQuestion() {
        num = RandomUtil.getInt();
        System.out.println("Question: " + num);
    }

    public static void greeting() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    public static Boolean isRight(String answer) {
        int res = num % 2;
        return (res == 0 && YES.equals(answer)) || (res == 1 && NO.equals(answer));
    }

    public static String rightAnswer() {
        int res = num % 2;
        return (res == 0 ? YES : NO);
    }

}
