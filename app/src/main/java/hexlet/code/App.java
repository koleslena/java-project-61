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

        Games.introduction();

        final Scanner scanner = new Scanner(System.in);

        final String game = scanner.next();

        System.out.println("Your choice: " + game);

        PlayGame.play(Integer.valueOf(game), scanner);

        scanner.close();
    }
}
