package org.rps.core;

import org.rps.hands.Lizard;

public class ExtendedHandFactory extends HandFactory {
    protected static final Hand lizard = new Lizard();
    private static ExtendedHandFactory instance;

    protected ExtendedHandFactory() {
        super();  // This will create the original hands and rules
        createLizardHand();
        // Update existing hands to handle Lizard
    }

    public static ExtendedHandFactory getInstance() {
        if (instance == null) {
            instance = new ExtendedHandFactory();
        }
        return instance;
    }

    protected void createLizardHand() {
        // Only rock wins against Lizard
        lizard.addRule(scissors, Outcome.WIN);
        lizard.addRule(paper, Outcome.WIN);
        // For other hands, Lizard wins by default (due to the default LOSE in Hand interface)
    }

    public Hand getLizardHand() {
        return lizard;
    }

    @Override
    protected void createRockHand() {
        super.createRockHand();
        rock.addRule(lizard, Outcome.WIN);
    }
} 