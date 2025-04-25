package org.snap;

import java.util.ArrayList;

public class CardGame {
    private ArrayList<Card> deckOfCards;
    private String name;

    public CardGame(String name){
        this.name = name;
        this.deckOfCards = new ArrayList<>();
        createDeck();
    }

    private void createDeck() {
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
