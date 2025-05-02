package org.snap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class CardGame implements Playable {
    protected static ArrayList<Card> deckOfCards = new ArrayList<>(52);
    protected Player playerOne;
    protected Player playerTwo;

    public CardGame(Player playerOne, Player playerTwo){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public static void resetDeck() {
        deckOfCards.clear();

        String[] symbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        for(Suit suit: Suit.values()) {
            for (int i = 0; i < symbols.length; i++) {
                deckOfCards.add(new Card(suit, symbols[i], values[i]));
            }
        }
    }

    public ArrayList<Card> getDeck(){
        return deckOfCards;
    }

    public Card dealCard(){
        return deckOfCards.isEmpty() ? null : deckOfCards.removeFirst();
    }

    public ArrayList<Card> sortDeckInNumberOrder() {
        deckOfCards.sort(Comparator.comparing(Card::getValue));
        return deckOfCards;
    }

    public ArrayList<Card> sortDeckIntoSuits() {
        deckOfCards.sort(Comparator.comparing(Card::getSuit).thenComparing(Card::getValue));
        return deckOfCards;
    }

    public ArrayList<Card> shuffleDeck() {
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }

    public abstract void play();

}
