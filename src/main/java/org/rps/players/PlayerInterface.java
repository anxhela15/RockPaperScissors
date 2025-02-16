package org.rps.players;

public interface PlayerInterface {

    default public int getScore() {
        return 1;
    }
    public void incrementScore();
    public void resetScore();
}
