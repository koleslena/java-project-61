package hexlet.code.games;

import java.util.Scanner;

public final class GreetGame extends AbstractGame {

    public GreetGame(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void play() {
        this.greeting();
    }

    @Override
    public String introduction() {
        return "";
    }

    @Override
    public StringBuilder question() {
        return null;
    }

    @Override
    public boolean isRight(String answer) {
        return false;
    }

    @Override
    public String rightAnswer() {
        return "";
    }
}
