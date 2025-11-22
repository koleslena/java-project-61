package hexlet.code;

import java.util.Scanner;

public class GreetGame {

    protected String userName;
    protected Scanner scanner;

    public GreetGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name? ");
        this.userName = this.scanner.next();
        System.out.println("Hello, " + this.userName + "!");
    }
}
