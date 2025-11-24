package hexlet.code.game;

import hexlet.code.RandomUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntBinaryOperator;

public class CalcGame {
    private static final Map<String, IntBinaryOperator> OPERATORS_MAP = new HashMap<>();

    static {
        OPERATORS_MAP.put("+", Integer::sum);
        OPERATORS_MAP.put("-", (a, b) -> a - b);
        OPERATORS_MAP.put("*", (a, b) -> a * b);
        OPERATORS_MAP.put("/", (a, b) -> a / b);
    }

    private static int result;

    public static String initQuestion() {
        int numOne = RandomUtil.getInt();
        int numTwo = RandomUtil.getInt();
        String operator = new ArrayList<>(OPERATORS_MAP.keySet()).get(RandomUtil.getInt(4));
        result = OPERATORS_MAP.get(operator).applyAsInt(numOne, numTwo);
        return "Question: " + numOne + " " + operator + " " + numTwo;
    }

    public static String greeting() {
        return "What is the result of the expression?";
    }

    public static boolean isRight(String answer) {
        return Integer.valueOf(answer).equals(result);
    }

    public static String rightAnswer() {
        return String.valueOf(result);
    }
}
