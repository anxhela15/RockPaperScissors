package org.rps.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IOProvider {
    private final Scanner inputScanner;

    public IOProvider() {
        this.inputScanner = new Scanner(System.in);
    }

    public synchronized String getString() {
        return inputScanner.next();
    }

    public synchronized Integer getInt() {
        Integer number = null;
        do {
            try {
                number = inputScanner.nextInt();
            } catch (InputMismatchException e) {
                printWithNewLine("Invalid input. Please enter a number.");
                inputScanner.next();
            }
        } while (number == null);
        return number;

    }

    public synchronized void printWithNewLine(String printableString) {
        System.out.println(printableString);
        System.out.flush();
    }

    public synchronized void print(String printableString) {
        System.out.print(printableString);
        System.out.flush();
    }
}