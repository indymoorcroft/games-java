package org.snap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {
    private static ArrayList<Card> deckOfCards = new ArrayList<>(52);
    private String name;

    static {
        createDeck();
    }

    public CardGame(String name){
        this.name = name;
    }

    private static void createDeck() {
        if (!deckOfCards.isEmpty()) return;

        String[] suits = {"♥", "♦", "♣", "♠"};
        String[] symbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        for(String suit: suits){
            for(int i = 0; i < symbols.length; i++){
                deckOfCards.add(new Card(suit, symbols[i], values[i]));
            }
        }
    }

    public ArrayList<Card> getDeck(){
        return deckOfCards;
    }

    public Card dealCard(){
        if (!deckOfCards.isEmpty()) {
            return deckOfCards.removeFirst();
        }
        return null;
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
        ArrayList<Card> copy = new ArrayList<>(deckOfCards);
        Collections.shuffle(copy);
        deckOfCards = copy;
        return deckOfCards;
    }

}
