package org.snap;

public class Card {
    private final Suit suit;
    private final String symbol;
    private final int value;

    public Card(Suit suit, String symbol, int value){
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return  symbol + " " + suit.getSymbol();
    }
}
