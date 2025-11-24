package hexlet.code.games;

import java.util.Scanner;

public class GCDGame extends AbstractGame {

    private int numOne;
    private int numTwo;
    private int result;

    public GCDGame(Scanner scanner) {
        super(scanner);
    }

    private int calcGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    protected void greeting() {
        super.greeting();
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    @Override
    protected void initQuestion() {
        this.numOne = random.nextInt(MAX - MIN + 1) + MIN;
        this.numTwo = random.nextInt(MAX - MIN + 1) + MIN;
        this.result = this.calcGCD(this.numOne, this.numTwo);
    }

    @Override
    protected void question() {
        System.out.println("Question: " + this.numOne + " " + this.numTwo);
    }

    @Override
    protected boolean isRight(String answer) {
        return Integer.valueOf(answer).equals(this.result);
    }

    @Override
    protected String rightAnswer() {
        return String.valueOf(this.result);
    }
}
