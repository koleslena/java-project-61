package hexlet.code;

import java.util.Scanner;

/**
 * Cli command line class.
 */
public class Cli {
    /**
     * Greeting method.
     */
    public static void greetings() {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("May I have your name? ");
        final String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        scanner.close();
    }
}

