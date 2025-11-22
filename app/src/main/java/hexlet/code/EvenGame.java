package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenGame extends GreetGame {

    private int SUCCESSFUL_ATTEMPTS = 3;

    private static final String NO = "no";
    private static final String YES = "yes";

    private static int MIN = 1;
    private static int MAX = 100;

    public EvenGame(Scanner scanner) {
        super(scanner);
    }

    private void question(String q) {
        System.out.println("Question: " + q);
    }

    private boolean isRight(int num, String answer) {
        int res = num % 2;
        return (res == 0 && YES.equals(answer)) || (res == 1 && NO.equals(answer));
    }

    private String rightAnswer(int num) {
        int res = num % 2;
        return (res == 0 ? YES : NO);
    }

    private String cover(String text) {
        return "'" + text + "'";
    }

    @Override
    public void play() {
        super.play();

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        Random random = new Random();
        int attemps = 0;
        while (attemps < SUCCESSFUL_ATTEMPTS) {
            int num = random.nextInt(MAX - MIN + 1) + MIN;
            question(String.valueOf(num));

            final String answer = this.scanner.next();
            System.out.println("Your answer: " + answer);

            if (this.isRight(num, answer)){
                System.out.println("Correct!");
                attemps++;
            } else {
                System.out.println(this.cover(answer) +
                        " is wrong answer ;(. Correct answer was " +
                        this.cover(this.rightAnswer(num)) + ".");
                System.out.println("Let's try again, " + this.userName + "!");
                attemps = 0;
            }
        }
        System.out.println("Congratulations, " + this.userName + "!");
    }
}
