package org.rps.core;

import java.util.Map;

public interface Hand {

    Map<Hand, Outcome> getRules();
    String getName();
    void addRule(Hand hand, Outcome outcome);

    default Outcome getOutcome(Hand hand) {

        if (this == hand) {
            return Outcome.DRAW;
        }

        return getRules().getOrDefault(hand, Outcome.LOSE);
    }

    default Outcome playAgainst(Hand hand) {
        return getOutcome(hand);
    }
}
