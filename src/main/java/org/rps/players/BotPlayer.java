package org.rps.players;

import org.rps.core.Hand;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class BotPlayer extends Player {

    @Override
    public Hand getHand(Map<String, Hand> handMap) {

        List<Hand> hands = new ArrayList<>(handMap.values());
        Random random = new Random();
        int randomIndex = random.nextInt(hands.size());
        return hands.get(randomIndex);
    }
}