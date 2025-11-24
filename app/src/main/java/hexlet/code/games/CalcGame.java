package hexlet.code.games;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.function.IntBinaryOperator;

public class CalcGame extends AbstractGame {

    private static final Map<String, IntBinaryOperator> OPERATORS_MAP = new HashMap<>();

    static {
        OPERATORS_MAP.put("+", Integer::sum);
        OPERATORS_MAP.put("-", (a, b) -> a - b);
        OPERATORS_MAP.put("*", (a, b) -> a * b);
        OPERATORS_MAP.put("/", (a, b) -> a / b);
    }

    private int numOne;
    private int numTwo;
    private int result;
    private String operator;

    public CalcGame(Scanner scanner) {
        super(scanner);
    }

    protected void greeting() {
        super.greeting();
        System.out.println("What is the result of the expression?");
    }

    @Override
    protected void initQuestion() {
        this.numOne = random.nextInt(MAX - MIN + 1) + MIN;
        this.numTwo = random.nextInt(MAX - MIN + 1) + MIN;
        this.operator = new ArrayList<>(OPERATORS_MAP.keySet()).get(random.nextInt(4));
        this.result = OPERATORS_MAP.get(this.operator).applyAsInt(this.numOne, this.numTwo);
    }

    @Override
    protected void question() {
        System.out.println("Question: " + this.numOne + " "
                + this.operator + " " + this.numTwo);
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
