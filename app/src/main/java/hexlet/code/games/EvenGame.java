package hexlet.code.games;

import java.util.Scanner;

public class EvenGame extends AbstractGame {

    private static final String NO = "no";
    private static final String YES = "yes";

    private int num;

    public EvenGame(Scanner scanner) {
        super(scanner);
    }

    protected StringBuilder question() {
        this.num = random.nextInt(MAX - MIN + 1) + MIN;
        StringBuilder sb = new StringBuilder("Question: ");
        sb.append(this.num);
        return sb;
    }

    protected StringBuilder greeting() {
        StringBuilder sb = super.greeting();
        sb.append("Answer 'yes' if the number is even, otherwise answer 'no'.");
        return sb;
    }

    protected boolean isRight(String answer) {
        int res = this.num % 2;
        return (res == 0 && YES.equals(answer)) || (res == 1 && NO.equals(answer));
    }

    protected String rightAnswer() {
        int res = this.num % 2;
        return (res == 0 ? YES : NO);
    }

}
