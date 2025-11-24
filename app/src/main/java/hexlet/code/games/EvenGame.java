package hexlet.code.games;

import java.util.Scanner;

public class EvenGame extends AbstractGame {

    private static final String NO = "no";
    private static final String YES = "yes";

    private int num;

    public EvenGame(Scanner scanner) {
        super(scanner);
    }

    public StringBuilder question() {
        this.num = random.nextInt(MAX - MIN + 1) + MIN;
        StringBuilder sb = new StringBuilder("Question: ");
        sb.append(this.num);
        return sb;
    }

    @Override
    public String introduction() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    public boolean isRight(String answer) {
        int res = this.num % 2;
        return (res == 0 && YES.equals(answer)) || (res == 1 && NO.equals(answer));
    }

    @Override
    public String rightAnswer() {
        int res = this.num % 2;
        return (res == 0 ? YES : NO);
    }

}
