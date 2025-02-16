package org.rps.players;

import java.util.Map;
import org.rps.core.Hand;

public abstract class Player {
    private int score;

    public abstract Hand getHand(Map<String, Hand> handMap);

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        this.score++;
    }

    public void resetScore() {
        this.score = 0;
    }
}
