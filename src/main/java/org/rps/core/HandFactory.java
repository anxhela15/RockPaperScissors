package org.rps.core;

import org.rps.hands.Paper;
import org.rps.hands.Rock;
import org.rps.hands.Scissors;

public class HandFactory {

    private static HandFactory instance;
    protected static final Hand rock = new Rock();
    protected static final Hand paper = new Paper();
    protected static final Hand scissors = new Scissors();

    protected HandFactory() {
        createRockHand();
        createScissorsHand();
        createPaperHand();
    }

    public static HandFactory getInstance() {
        if (instance == null) {
            instance = new HandFactory();
        }
        return instance;
    }

    protected void createRockHand() {
        rock.addRule(scissors, Outcome.WIN);
        rock.addRule(paper, Outcome.LOSE);
    }

    protected void createScissorsHand() {
        scissors.addRule(rock, Outcome.LOSE);
        scissors.addRule(paper, Outcome.WIN);
    }

    protected void createPaperHand() {
        paper.addRule(scissors, Outcome.LOSE);
        paper.addRule(rock, Outcome.WIN);
    }

    public Hand getRockHand() {
        return rock;
    }
    public Hand getScissorsHand() {
        return scissors;
    }
    public Hand getPaperHand() {
        return paper;
    }
}

