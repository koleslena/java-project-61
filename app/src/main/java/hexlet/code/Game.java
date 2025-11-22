package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public enum Game {
    DEFAULT("Default", "-1"),
    EXIT("Exit", "0"),
    GREET("Greet", "1"),
    EVEN("Even", "2"),
    CALC("Calc", "3"),
    GCD("GCD", "4"),
    PROGRESSION("Progression", "5"),
    PRIME("Prime", "6");

    private final String number;
    private final String name;

    public static final Map<String, Game> NUMBER_MAP = new HashMap<>();

    static {
        for (Game game : values()) {
            if (game != DEFAULT) {
                NUMBER_MAP.put(game.number, game);
            }
        }
    }

    Game(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public static Game fromNumber(String number) {
        Game game = NUMBER_MAP.get(number);
        if (game == null) {
            return DEFAULT;
        }
        return game;
    }

    public static String printGames() {
        StringBuilder sb = new StringBuilder("Please enter the game number and press Enter.\n");
        for (Game game : NUMBER_MAP.values()) {
            sb.append(game.number + " - " + game.name + "\n");
        }
        return sb.toString();
    }
}
