package org.rps.game;

import org.rps.core.ExtendedHandFactory;
import org.rps.core.Hand;
import org.rps.players.Player;
import org.rps.utils.IOProvider;

import java.util.HashMap;
import java.util.Map;

public class RpslGame extends TwoPlayerGame {

    private Map<String, Hand> handMap;

    public RpslGame(Player firstPlayer, Player secondPlayer, IOProvider ioProvider) {
        super(firstPlayer, secondPlayer, ioProvider);
        initializeGame();
    }

    private void initializeGame() {
        ExtendedHandFactory handFactory = ExtendedHandFactory.getInstance();

        this.handMap = new HashMap<>();
        this.handMap.put("r", handFactory.getRockHand());
        this.handMap.put("p", handFactory.getPaperHand());
        this.handMap.put("s", handFactory.getScissorsHand());
        this.handMap.put("l", handFactory.getLizardHand());
    }

    @Override
    public void play() {

        ioProvider.printWithNewLine("Welcome to the Game of Rock-Paper-Scissors-Lizard");
        ioProvider.printWithNewLine("");

        super.playHands(handMap);

    }
}
