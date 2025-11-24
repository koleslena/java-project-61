package hexlet.code.games;

import java.util.Scanner;

public final class PrimeGame extends AbstractGame {

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

    @Override
    public String introduction() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    public StringBuilder question() {
        this.number = RANDOM.nextInt(MAX - MIN + 1) + MIN;
        StringBuilder sb = new StringBuilder("Question: ");
        sb.append(this.number);
        return sb;
    }

    @Override
    public boolean isRight(String answer) {
        boolean prime = this.isPrime(this.number);
        return prime == YES.equals(answer);
    }

    @Override
    public String rightAnswer() {
        return this.isPrime(this.number) ? YES : NO;
    }

}
