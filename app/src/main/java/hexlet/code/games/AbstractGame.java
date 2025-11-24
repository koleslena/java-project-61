package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public abstract class AbstractGame extends GreetGame implements GameInterface {
    protected static final int MIN = 1;
    protected static final int MAX = 100;

    private static final int SUCCESSFUL_ATTEMPTS = 3;

    protected final Random random = new Random();

    protected abstract void initQuestion();

    protected abstract void question();

    protected abstract boolean isRight(String answer);

    protected abstract String rightAnswer();

    private String cover(String text) {
        return "'" + text + "'";
    }

    public AbstractGame(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void play() {
        this.greeting();

        int attemps = 0;
        while (attemps < SUCCESSFUL_ATTEMPTS) {

            this.initQuestion();

            question();

            final String answer = this.scanner.next();
            System.out.println("Your answer: " + answer);

            if (this.isRight(answer)) {
                System.out.println("Correct!");
                attemps++;
            } else {
                System.out.println(this.cover(answer)
                        + " is wrong answer ;(. Correct answer was "
                        + this.cover(this.rightAnswer()) + ".");
                System.out.println("Let's try again, " + this.userName + "!");
                attemps = 0;
            }
        }
        System.out.println("Congratulations, " + this.userName + "!");
    }
}
