package hexlet.code.games;

import java.util.Scanner;

public class GreetGame implements GameInterface {

    protected String userName;
    protected Scanner scanner;

    public GreetGame(Scanner scanner) {
        this.scanner = scanner;
    }

    protected StringBuilder greeting() {
        StringBuilder sb = new StringBuilder("Welcome to the Brain Games!\n");
        sb.append("May I have your name? \n");
        this.userName = this.scanner.next();
        sb.append("Hello, ").append(this.userName).append("!");
        return sb;
    }

    public void play() {
        this.greeting();
    }
}
