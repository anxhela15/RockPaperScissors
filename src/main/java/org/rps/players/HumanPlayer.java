package org.rps.players;

import org.rps.core.Hand;
import org.rps.utils.IOProvider;

import java.util.Map;

public class HumanPlayer extends Player {

    private final IOProvider ioProvider;

    public HumanPlayer(IOProvider ioProvider) {
        this.ioProvider = ioProvider;
    }

    @Override
    public Hand getHand(Map<String, Hand> handMap) {
        String userChoice;
        String availableChoices = String.join(", ", handMap.keySet());

        do {
            ioProvider.print("Choose your move (" + availableChoices + "): ");
            userChoice = ioProvider.getString().toLowerCase();

            if (!handMap.containsKey(userChoice)) {
                ioProvider.printWithNewLine("Invalid choice. Please select one of the available options: " + availableChoices);
            }
        } while (!handMap.containsKey(userChoice));

        return handMap.get(userChoice);
    }
}