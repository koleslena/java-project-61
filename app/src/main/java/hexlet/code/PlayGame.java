package hexlet.code;

import java.util.Scanner;
import java.util.function.Supplier;

import static hexlet.code.Games.GAMES_IS_RIGHT;
import static hexlet.code.Games.GREETING_METHOD;
import static hexlet.code.Games.INIT_QUESTION_METHOD;
import static hexlet.code.Games.RIGHT_ANSWER;
import static hexlet.code.Games.GAMES_FUNCTIONS;

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

            Supplier<String>[] methods = GAMES_FUNCTIONS[gameIdx - 2];
            System.out.println(methods[GREETING_METHOD].get());

            for (int i = 0; i < SUCCESSFUL_ATTEMPTS; i++) {

                System.out.println(methods[INIT_QUESTION_METHOD].get());

                final String answer = scanner.next();
                System.out.println("Your answer: " + answer);

                boolean isRight = GAMES_IS_RIGHT[gameIdx - 2].apply(answer);
                if (isRight) {
                    System.out.println("Correct!");
                } else {
                    String rightAnswer = methods[RIGHT_ANSWER].get();
                    System.out.println(cover(answer)
                            + " is wrong answer ;(. Correct answer was "
                            + cover(rightAnswer) + ".");
                    System.out.println("Let's try again, " + userName + "!");
                    return;
                }
            }
            System.out.println("Congratulations, " + userName + "!");
        }
    }

    private static String cover(String text) {
        return "'" + text + "'";
    }
}
