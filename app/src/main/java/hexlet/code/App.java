package hexlet.code;

import java.util.Scanner;

/**
 * App main.
 */
public class App {

    /**
     * App main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        System.out.print(Game.printGames());

        final Scanner scanner = new Scanner(System.in);

        final String game = scanner.next();

        System.out.println("Your choice: " + game);

        switch (Game.fromNumber(game)) {
            case Game.DEFAULT:
                System.out.println("There is no game " + game + "!");
                break;
            case Game.GREET:
                new GreetGame(scanner).play();
                break;
            case Game.EVEN:
                new EvenGame(scanner).play();
                break;
            case Game.CALC:
                new CalcGame(scanner).play();
                break;
            case Game.GCD:
                new GCDGame(scanner).play();
                break;
            case Game.PROGRESSION:
                new ProgressionGame(scanner).play();
                break;
            case Game.PRIME:
                new PrimeGame(scanner).play();
                break;
            default:
                break;
        }

        scanner.close();
    }
}
