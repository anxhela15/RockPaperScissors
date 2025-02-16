package org.rps.hands;

import org.rps.core.Hand;
import org.rps.core.Outcome;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

abstract class AbstractHand implements Hand {

    private final String name;
    Map<Hand, Outcome> rules;


    public AbstractHand(String name) {
        this.name = name;
        this.rules = new HashMap<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addRule(Hand hand, Outcome outcome) {
        rules.put(hand, outcome);
    }

    public Map<Hand, Outcome> getRules() {
        return Collections.unmodifiableMap(rules);
    }

}
