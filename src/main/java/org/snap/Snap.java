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
                System.out.println("SNAP! " + currentPlayer.getName() + " wins!");
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
}
