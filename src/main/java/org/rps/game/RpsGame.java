package org.rps.game;

import org.rps.core.Hand;
import org.rps.core.HandFactory;
import org.rps.players.Player;
import org.rps.utils.IOProvider;

import java.util.HashMap;
import java.util.Map;

public class RpsGame extends TwoPlayerGame {

    private Map<String, Hand> handMap;

    public RpsGame(Player firstPlayer, Player secondPlayer, IOProvider ioProvider) {
        super(firstPlayer, secondPlayer, ioProvider);
        initializeGame();
    }

    private void initializeGame() {
        HandFactory handFactory = HandFactory.getInstance();

        this.handMap = new HashMap<>();
        this.handMap.put("r", handFactory.getRockHand());
        this.handMap.put("p", handFactory.getPaperHand());
        this.handMap.put("s", handFactory.getScissorsHand());
    }

    @Override
    public void play() {

        ioProvider.printWithNewLine("Welcome to the Game of Rock-Paper-Scissors");
        ioProvider.printWithNewLine("");

        super.playHands(handMap);

    }
}
