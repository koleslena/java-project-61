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

    private int result;

    public CalcGame(Scanner scanner) {
        super(scanner);
    }

    protected StringBuilder greeting() {
        StringBuilder sb = super.greeting();
        sb.append("\nWhat is the result of the expression?");
        return sb;
    }

    @Override
    protected StringBuilder question() {
        int numOne = random.nextInt(MAX - MIN + 1) + MIN;
        int numTwo = random.nextInt(MAX - MIN + 1) + MIN;
        String operator = new ArrayList<>(OPERATORS_MAP.keySet()).get(random.nextInt(4));
        this.result = OPERATORS_MAP.get(operator).applyAsInt(numOne, numTwo);

        StringBuilder sb = new StringBuilder("Question: ");
        sb.append(numOne).append(" ")
                .append(operator)
                .append(" ")
                .append(numTwo);
        return sb;
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
