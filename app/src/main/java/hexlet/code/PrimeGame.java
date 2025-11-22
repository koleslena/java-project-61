package hexlet.code;

import java.util.Scanner;

public class PrimeGame extends AbstractGame {

    private static final String NO = "no";
    private static final String YES = "yes";

    private int number;

    public PrimeGame(Scanner scanner) {
        super(scanner);
    }

    private boolean isPrime(int n) {
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

    protected void greeting() {
        super.greeting();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    @Override
    protected void initQuestion() {
        this.number = random.nextInt(MAX - MIN + 1) + MIN;
    }

    @Override
    protected void question() {
        System.out.println("Question: " + this.number);
    }

    @Override
    protected boolean isRight(String answer) {
        boolean prime = this.isPrime(this.number);
        return prime == YES.equals(answer);
    }

    @Override
    protected String rightAnswer() {
        return this.isPrime(this.number) ? YES : NO;
    }

}
