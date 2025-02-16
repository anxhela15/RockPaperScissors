package org.rps;

import org.rps.game.RpsGame;
import org.rps.game.RpslGame;
import org.rps.players.Player;
import org.rps.players.BotPlayer;
import org.rps.players.HumanPlayer;
import org.rps.utils.IOProvider;

public class Main {
    public static void main(String[] args) {

        IOProvider ioProvider = new IOProvider();
        Player humanPlayer = new HumanPlayer(ioProvider);
        Player computerPlayer = new BotPlayer();

        //RpsGame game = new RpsGame(humanPlayer, computerPlayer, ioProvider);
        //game.play();

        RpslGame game = new RpslGame(humanPlayer, computerPlayer, ioProvider);
        game.play();

    }
}