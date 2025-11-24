package hexlet.code.games;

import java.util.Scanner;

public class ProgressionGame extends AbstractGame {

    private static final int SIZE = 10;

    private int start;
    private int step;
    private int resultIdx;

    public ProgressionGame(Scanner scanner) {
        super(scanner);
    }

    private Integer getNext(int index) {
        return this.start + this.step * index;
    }

    @Override
    protected StringBuilder question() {
        this.start = random.nextInt(MAX - MIN + 1) + MIN;
        this.step = random.nextInt(1, 10);
        this.resultIdx = random.nextInt(SIZE);

        StringBuilder sb = new StringBuilder("Question: ");
        for (int i = 0; i < SIZE; i++) {
            if (i != this.resultIdx) {
                sb.append(this.getNext(i));
                sb.append(" ");
            } else {
                sb.append(".. ");
            }
        }
        return sb;
    }

    protected StringBuilder greeting() {
        StringBuilder sb = super.greeting();
        sb.append("What number is missing in the progression?");
        return sb;
    }

    @Override
    protected boolean isRight(String answer) {
        return Integer.valueOf(answer).equals(this.getNext(this.resultIdx));
    }

    @Override
    protected String rightAnswer() {
        return this.getNext(this.resultIdx).toString();
    }
}
