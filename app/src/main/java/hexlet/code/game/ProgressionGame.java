package hexlet.code.game;

import hexlet.code.RandomUtil;

public class ProgressionGame {
    private static final int SIZE = 10;

    private static int start;
    private static int step;
    private static int resultIdx;

    public static String initQuestion() {
        start = RandomUtil.getInt();
        step = RandomUtil.getInt(1, 10);
        resultIdx = RandomUtil.getInt(SIZE);

        StringBuilder sb = new StringBuilder("Question: ");
        for (int i = 0; i < SIZE; i++) {
            if (i != resultIdx) {
                sb.append(getNext(i));
                sb.append(" ");
            } else {
                sb.append(".. ");
            }
        }
        return sb.toString();
    }

    private static Integer getNext(int index) {
        return start + step * index;
    }

    public static String greeting() {
        return "What number is missing in the progression?";
    }

    public static boolean isRight(String answer) {
        return Integer.valueOf(answer).equals(getNext(resultIdx));
    }

    public static String rightAnswer() {
        return getNext(resultIdx).toString();
    }
}
