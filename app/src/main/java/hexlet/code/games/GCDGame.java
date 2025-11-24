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

    @Override
    public String introduction() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    public StringBuilder question() {
        this.numOne = random.nextInt(MAX - MIN + 1) + MIN;
        this.numTwo = random.nextInt(MAX - MIN + 1) + MIN;
        this.result = this.calcGCD(this.numOne, this.numTwo);

        StringBuilder sb = new StringBuilder("Question: ");
        sb.append(this.numOne)
                .append(" ")
                .append(this.numTwo);
        return sb;
    }

    @Override
    public boolean isRight(String answer) {
        return Integer.valueOf(answer).equals(this.result);
    }

    @Override
    public String rightAnswer() {
        return String.valueOf(this.result);
    }
}
