package org.rps.players;

public class PlayerConcrete implements PlayerInterface {

    private int score;

    public void incrementScore() {
        this.score++;
    }

    public void resetScore() {
        this.score = 0;
    }

}
