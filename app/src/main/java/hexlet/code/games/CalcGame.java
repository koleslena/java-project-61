package hexlet.code.games;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.function.IntBinaryOperator;

public final class CalcGame extends AbstractGame {

    private static final Map<String, IntBinaryOperator> OPERATORS_MAP = new HashMap<>();
    public static final int OPERATORS = 4;

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

    @Override
    public String introduction() {
        return "What is the result of the expression?";
    }

    @Override
    public StringBuilder question() {
        int numOne = RANDOM.nextInt(MAX - MIN + 1) + MIN;
        int numTwo = RANDOM.nextInt(MAX - MIN + 1) + MIN;
        String operator = new ArrayList<>(OPERATORS_MAP.keySet()).get(RANDOM.nextInt(OPERATORS));
        this.result = OPERATORS_MAP.get(operator).applyAsInt(numOne, numTwo);

        StringBuilder sb = new StringBuilder("Question: ");
        sb.append(numOne).append(" ")
                .append(operator)
                .append(" ")
                .append(numTwo);
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
