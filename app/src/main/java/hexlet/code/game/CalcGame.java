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

    private static int numOne;
    private static int numTwo;
    private static int result;
    private static String operator;
    
    public static void initQuestion() {
        numOne = RandomUtil.getInt();
        numTwo = RandomUtil.getInt();
        operator = new ArrayList<>(OPERATORS_MAP.keySet()).get(RandomUtil.getInt(4));
        result = OPERATORS_MAP.get(operator).applyAsInt(numOne, numTwo);
        System.out.println("Question: " + numOne + " "
                + operator + " " + numTwo);
    }

    public static void greeting() {
        System.out.println("What is the result of the expression?");
    }

    public static boolean isRight(String answer) {
        return Integer.valueOf(answer).equals(result);
    }

    public static String rightAnswer() {
        return String.valueOf(result);
    }
}
