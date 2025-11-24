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

    public static final Runnable[][] GAMES_RUN = new Runnable[5][2];
    public static final Function<String, Boolean>[] GAMES_IS_RIGHT = new Function[5];
    public static final Supplier<String>[] GAMES_RIGHT = new Supplier[5];
    public static final String[] GAME_NAMES = new String[7];

    static {
        GAMES_RUN[0] = new Runnable[]{EvenGame::greeting, EvenGame::initQuestion};
        GAMES_IS_RIGHT[0] = EvenGame::isRight;
        GAMES_RIGHT[0] = EvenGame::rightAnswer;

        GAMES_RUN[1] = new Runnable[]{CalcGame::greeting, CalcGame::initQuestion};
        GAMES_IS_RIGHT[1] = CalcGame::isRight;
        GAMES_RIGHT[1] = CalcGame::rightAnswer;

        GAMES_RUN[2] = new Runnable[]{GCDGame::greeting, GCDGame::initQuestion};
        GAMES_IS_RIGHT[2] = GCDGame::isRight;
        GAMES_RIGHT[2] = GCDGame::rightAnswer;

        GAMES_RUN[3] = new Runnable[]{ProgressionGame::greeting, ProgressionGame::initQuestion};
        GAMES_IS_RIGHT[3] = ProgressionGame::isRight;
        GAMES_RIGHT[3] = ProgressionGame::rightAnswer;

        GAMES_RUN[4] = new Runnable[]{PrimeGame::greeting, PrimeGame::initQuestion};
        GAMES_IS_RIGHT[4] = PrimeGame::isRight;
        GAMES_RIGHT[4] = PrimeGame::rightAnswer;

        GAME_NAMES[0] = "Exit";
        GAME_NAMES[1] = "Greet";
        GAME_NAMES[2] = "Even";
        GAME_NAMES[3] = "Calc";
        GAME_NAMES[4] = "GCD";
        GAME_NAMES[5] = "Progression";
        GAME_NAMES[6] = "Prime";
    }

    public static void introduction() {
        StringBuilder sb = new StringBuilder("Please enter the game number and press Enter.\n");
        for (int i = 0; i < GAME_NAMES.length; i++) {
            sb.append(i)
                    .append(" - ")
                    .append(GAME_NAMES[i])
                    .append("\n");
        }
        System.out.println(sb);
    }
}
