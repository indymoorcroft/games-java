package org.snap;

import java.util.Scanner;

public class SnapUtils {
    public static boolean isSnap(Card prevCard, Card currCard) {
        return prevCard != null && currCard.getSymbol().equals(prevCard.getSymbol());
    }

    public static boolean handleComputerSnap(){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        boolean result = Math.random() < 0.5;

        if(result){
            System.out.println("snap");
            return true;
        }

        return false;
    }

    public static boolean snapInput (Scanner scanner) {
        final String[] result = {null};

        Thread inputThread = new Thread(() -> {
            String input = scanner.nextLine().trim().toLowerCase();
            result[0] = input;
        });

        inputThread.start();

        try {
            inputThread.join(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return "snap".equals(result[0]);
    }

    public static void printSnapWinner(Player currentPlayer, Player playerOne, Player playerTwo, boolean success) {
        if(success){
            System.out.printf("\nCorrect! %s wins!\n", currentPlayer.getName());
            currentPlayer.incrementScore();
        } else {
            System.out.printf("\nToo slow! %s loses!\n", currentPlayer.getName());
            Player winner = (currentPlayer == playerOne) ? playerTwo : playerOne;
            winner.incrementScore();
            System.out.println(winner.getName() + " wins!");
        }
    }
}
