package hexlet.code;

import hexlet.code.game.EvenGame;
import hexlet.code.game.CalcGame;
import hexlet.code.game.GCDGame;
import hexlet.code.game.ProgressionGame;
import hexlet.code.game.PrimeGame;

import java.util.function.Function;
import java.util.function.Supplier;

public class Games {

    public static final int GREETING_METHOD = 0;
    public static final int INIT_QUESTION_METHOD = 1;

    public static final Runnable[][] games_run = new Runnable[5][2];
    public static final Function<String, Boolean>[] games_is_right = new Function[5];
    public static final Supplier<String>[] games_right = new Supplier[5];
    public static final String[] gameNames = new String[7];

    static {
        games_run[0] = new Runnable[]{EvenGame::greeting, EvenGame::initQuestion};
        games_is_right[0] = EvenGame::isRight;
        games_right[0] = EvenGame::rightAnswer;

        games_run[1] = new Runnable[]{CalcGame::greeting, CalcGame::initQuestion};
        games_is_right[1] = CalcGame::isRight;
        games_right[1] = CalcGame::rightAnswer;

        games_run[2] = new Runnable[]{GCDGame::greeting, GCDGame::initQuestion};
        games_is_right[2] = GCDGame::isRight;
        games_right[2] = GCDGame::rightAnswer;

        games_run[3] = new Runnable[]{ProgressionGame::greeting, ProgressionGame::initQuestion};
        games_is_right[3] = ProgressionGame::isRight;
        games_right[3] = ProgressionGame::rightAnswer;

        games_run[4] = new Runnable[]{PrimeGame::greeting, PrimeGame::initQuestion};
        games_is_right[4] = PrimeGame::isRight;
        games_right[4] = PrimeGame::rightAnswer;

        gameNames[0] = "Exit";
        gameNames[1] = "Greet";
        gameNames[2] = "Even";
        gameNames[3] = "Calc";
        gameNames[4] = "GCD";
        gameNames[5] = "Progression";
        gameNames[6] = "Prime";
    }

    public static void introduction() {
        StringBuilder sb = new StringBuilder("Please enter the game number and press Enter.\n");
        for (int i = 0; i < gameNames.length; i++) {
            sb.append(i)
                    .append(" - ")
                    .append(gameNames[i])
                    .append("\n");
        }
        System.out.println(sb);
    }
}
