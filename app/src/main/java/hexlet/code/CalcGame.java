package hexlet.code;

import java.util.*;
import java.util.function.IntBinaryOperator;

public class CalcGame extends AbstractGame {
    private static final int MIN = 1;
    private static final int MAX = 100;

    public static final Map<String, IntBinaryOperator> operatorsMap = new HashMap<>();

    static {
        operatorsMap.put("+", Integer::sum);
        operatorsMap.put("-", (a, b) -> a - b);
        operatorsMap.put("*", (a, b) -> a * b);
        operatorsMap.put("/", (a, b) -> a / b);
    }

    private final Random random = new Random();

    private int numOne;
    private int numTwo;
    private int result;
    private String operator;

    public CalcGame(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected void initQuestion() {
        this.numOne = random.nextInt(MAX - MIN + 1) + MIN;
        this.numTwo = random.nextInt(MAX - MIN + 1) + MIN;
        this.operator = new ArrayList<>(operatorsMap.keySet()).get(random.nextInt(4));
        this.result = operatorsMap.get(this.operator).applyAsInt(this.numOne, this.numTwo);
    }

    @Override
    protected void question() {
        System.out.println("Question: " + this.numOne + " " +
                this.operator + " " + this.numTwo);
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
