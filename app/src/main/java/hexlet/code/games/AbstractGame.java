package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public abstract class AbstractGame implements GameInterface {
    protected static final int MIN = 1;
    protected static final int MAX = 100;

    private static final int SUCCESSFUL_ATTEMPTS = 3;

    protected static final Random RANDOM = new Random();

    public abstract String introduction();

    public abstract StringBuilder question();

    public abstract boolean isRight(String answer);

    public abstract String rightAnswer();

    private final Scanner scanner;

    private String userName;

    public AbstractGame(Scanner aScanner) {
        this.scanner = aScanner;
    }

    /**
     * Play games engine.
     */
    @Override
    public void play() {

        this.greeting();

        System.out.println(this.introduction());

        for (int i = 0; i < SUCCESSFUL_ATTEMPTS; i++) {
            System.out.println(this.question());

            final String answer = this.scanner.next();
            System.out.println("Your answer: " + answer);

            if (this.isRight(answer)) {
                System.out.println("Correct!");
            } else {
                System.out.println(this.cover(answer)
                        + " is wrong answer ;(. Correct answer was "
                        + this.cover(this.rightAnswer()) + ".");
                System.out.println("Let's try again, " + this.userName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + this.userName + "!");
    }

    protected final void greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        this.userName = scanner.next();
        System.out.println("Hello, " + this.userName + "!");
    }

    private String cover(String text) {
        return "'" + text + "'";
    }
}
