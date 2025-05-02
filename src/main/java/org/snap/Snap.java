package org.snap;

import java.util.Scanner;

public class Snap extends CardGame {

    public Snap(Player playerOne, Player playerTwo) {
        super(playerOne, playerTwo);
    }

    @Override
    public void play() {
        resetGame();

        Player currentPlayer = playerOne;
        Card previousCard = null;
        Scanner scanner = new Scanner(System.in);

        while(!deckOfCards.isEmpty()){

            System.out.printf("\n%s's turn. Press ENTER to draw a card.\n", currentPlayer.getName());
            scanner.nextLine();

            Card currentCard = dealCard();

            if(currentCard == null) {
                System.out.println("No more cards. It's a draw!");
                return;
            }

            System.out.println(currentCard);

            if (isSnap(previousCard, currentCard)) {
                boolean success = snapInput();

                if(success){
                    System.out.println("Correct! " + currentPlayer.getName() + " wins!");
                } else {
                    System.out.println("Too slow! " + currentPlayer.getName() + " loses!");
                    Player winner = (currentPlayer == playerOne) ? playerTwo : playerOne;
                    System.out.println(winner.getName() + " wins!");
                }

                return;
            } else {
                previousCard = currentCard;
                currentPlayer = (currentPlayer == playerOne) ? playerTwo : playerOne;
            }
        }
    }

    private void resetGame() {
        resetDeck();
        shuffleDeck();
        System.out.println("Hello! It's " + playerOne.getName() + " vs " + playerTwo.getName() + " Find two of the same value to win!");
    }

    private boolean isSnap(Card prevCard, Card currCard) {
        return prevCard != null && currCard.getSymbol().equals(prevCard.getSymbol());
    }

    private boolean snapInput () {
        final String[] result = {null};

        Thread inputThread = new Thread(() -> {
            Scanner snapScanner = new Scanner(System.in);
            String input = snapScanner.nextLine().trim().toLowerCase();
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
}
