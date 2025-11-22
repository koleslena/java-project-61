package hexlet.code;

import java.util.Scanner;

public class ProgressionGame extends AbstractGame {

    private static final int SIZE = 10;

    private int start;
    private int step;
    private int resultIdx;

    public ProgressionGame(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected void initQuestion() {
        this.start = random.nextInt(MAX - MIN + 1) + MIN;
        this.step = random.nextInt(1, 10);
        this.resultIdx = random.nextInt(SIZE);
    }

    private Integer getNext(int index) {
        return this.start + this.step * index;
    }

    @Override
    protected void question() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            if (i != this.resultIdx) {
                sb.append(this.getNext(i));
                sb.append(" ");
            } else {
                sb.append(".. ");
            }
        }
        System.out.println("Question: " + sb);
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
