package org.rps.game;

import org.rps.core.Hand;
import org.rps.core.Outcome;
import org.rps.players.Player;
import org.rps.utils.IOProvider;

import java.util.Map;

public abstract class TwoPlayerGame {

    protected final Player firstPlayer;
    protected final Player secondPlayer;
    protected final IOProvider ioProvider;

    public TwoPlayerGame(Player firstPlayer, Player secondPlayer, IOProvider ioProvider) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.ioProvider = ioProvider;
    }

    public abstract void play();

    protected void playHands(Map<String, Hand> handMap) {

        ioProvider.print("Enter the number of rounds you want to play: ");
        Integer roundsNo = ioProvider.getInt();

        firstPlayer.resetScore();
        secondPlayer.resetScore();

        for (int round = 1; round <= roundsNo; round++) {

            ioProvider.printWithNewLine("Round " + round + ":");

            Hand firstPlayerHand = firstPlayer.getHand(handMap);
            Hand secondPlayerHand = secondPlayer.getHand(handMap);

            ioProvider.printWithNewLine("Computer chose: " + secondPlayerHand.getName());
            Outcome outcome = firstPlayerHand.playAgainst(secondPlayerHand);
            ioProvider.printWithNewLine(outcome.getMessage());

            if(outcome == Outcome.WIN) {
                firstPlayer.incrementScore();
            } else if(outcome == Outcome.LOSE) {
                secondPlayer.incrementScore();
            }
        }

        ioProvider.printWithNewLine("Game Over!");
        ioProvider.printWithNewLine("Final Scores:");
        ioProvider.printWithNewLine("You: " + firstPlayer.getScore());
        ioProvider.printWithNewLine("Computer: " + secondPlayer.getScore());

        if (firstPlayer.getScore() > secondPlayer.getScore()) {
            ioProvider.printWithNewLine("Congratulations! You are the overall WINNER!");
        } else if (secondPlayer.getScore() > firstPlayer.getScore()) {
            ioProvider.printWithNewLine("Computer wins! Better luck next time!");
        } else {
            ioProvider.printWithNewLine("It's a DRAW overall!");
        }
    }
}
