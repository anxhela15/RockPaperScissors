package org.rps.core;

public enum Outcome {

    WIN("You win this round!"),
    LOSE("You lose this round!"),
    DRAW("It's a draw!");

    private final String message;

    Outcome(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}