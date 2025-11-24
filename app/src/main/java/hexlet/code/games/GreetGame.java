package hexlet.code.games;

import java.util.Scanner;

public class GreetGame implements GameInterface {

    protected String userName;
    protected Scanner scanner;

    public GreetGame(Scanner scanner) {
        this.scanner = scanner;
    }

    protected void greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name? ");
        this.userName = this.scanner.next();
        System.out.println("Hello, " + this.userName + "!");
    }

    public void play() {
        this.greeting();
    }
}
