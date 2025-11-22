package hexlet.code;

import java.util.Scanner;

public class EvenGame extends AbstractGame {

    private static final String NO = "no";
    private static final String YES = "yes";

    private int num;

    public EvenGame(Scanner scanner) {
        super(scanner);
    }

    protected void initQuestion() {
        this.num = random.nextInt(MAX - MIN + 1) + MIN;
    }

    protected void question() {
        System.out.println("Question: " + this.num);
    }

    protected void greeting() {
        super.greeting();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
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
