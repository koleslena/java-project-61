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
    public static final int RIGHT_ANSWER = 2;

    public static final Function<String, Boolean>[] GAMES_IS_RIGHT = new Function[5];
    public static final Supplier<String>[][] GAMES_FUNCTIONS = new Supplier[5][3];
    public static final String[] GAME_NAMES = new String[7];

    static {
        GAMES_FUNCTIONS[0] = new Supplier[]{EvenGame::greeting,
                                            EvenGame::initQuestion,
                                            EvenGame::rightAnswer};
        GAMES_IS_RIGHT[0] = EvenGame::isRight;

        GAMES_FUNCTIONS[1] = new Supplier[]{CalcGame::greeting,
                                            CalcGame::initQuestion,
                                            CalcGame::rightAnswer};
        GAMES_IS_RIGHT[1] = CalcGame::isRight;

        GAMES_FUNCTIONS[2] = new Supplier[]{GCDGame::greeting,
                                            GCDGame::initQuestion,
                                            GCDGame::rightAnswer};
        GAMES_IS_RIGHT[2] = GCDGame::isRight;

        GAMES_FUNCTIONS[3] = new Supplier[]{ProgressionGame::greeting,
                                            ProgressionGame::initQuestion,
                                            ProgressionGame::rightAnswer};
        GAMES_IS_RIGHT[3] = ProgressionGame::isRight;

        GAMES_FUNCTIONS[4] = new Supplier[]{PrimeGame::greeting,
                                            PrimeGame::initQuestion,
                                            PrimeGame::rightAnswer};
        GAMES_IS_RIGHT[4] = PrimeGame::isRight;

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
