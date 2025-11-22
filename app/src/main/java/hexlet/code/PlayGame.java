package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Games.*;

public class PlayGame {

    private static final int SUCCESSFUL_ATTEMPTS = 3;

    private static String greeting(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }

    public static void play(int gameIdx, Scanner scanner) {
        if (gameIdx == 0) {
            return;
        }

        String userName = greeting(scanner);

        if (gameIdx == 1) {
            return;
        }

        if (gameIdx > 1 && gameIdx < 7) {

            Runnable[] runnables = games_run[gameIdx - 2];
            runnables[GREETING_METHOD].run();

            int attemps = 0;
            while (attemps < SUCCESSFUL_ATTEMPTS) {

                runnables[INIT_QUESTION_METHOD].run();

                final String answer = scanner.next();
                System.out.println("Your answer: " + answer);

                boolean isRight = games_is_right[gameIdx - 2].apply(answer);
                if (isRight) {
                    System.out.println("Correct!");
                    attemps++;
                } else {
                    String rightAnswer = games_right[gameIdx - 2].get();
                    System.out.println(cover(answer)
                            + " is wrong answer ;(. Correct answer was "
                            + cover(rightAnswer) + ".");
                    System.out.println("Let's try again, " + userName + "!");
                    attemps = 0;
                }
            }
            System.out.println("Congratulations, " + userName + "!");
        }
    }

    private static String cover(String text) {
        return "'" + text + "'";
    }
}
