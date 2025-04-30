package org.snap;

import java.util.Scanner;

public class Snap extends CardGame {

    public Snap(String name) {
        super(name);
    }

    @Override
    public void play() {
        resetDeck();

        shuffleDeck();

        System.out.println("Hello " + name);
        System.out.println("Press ENTER to draw a card. Find two of the same value to win!");

        Scanner scanner = new Scanner(System.in);
        Card previousCard = null;

        while(!deckOfCards.isEmpty()){
            scanner.nextLine();

            Card currentCard = dealCard();

            if(currentCard == null) {
                System.out.println("No more cards. GAME OVER");
                return;
            }

            System.out.println(currentCard);

            if (previousCard != null && currentCard.getSymbol().equals(previousCard.getSymbol())) {
                System.out.println("SNAP! You win");
                return;
            }

            previousCard = currentCard;
        }
    }
}
