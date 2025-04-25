package org.snap;

import java.util.ArrayList;

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
}
