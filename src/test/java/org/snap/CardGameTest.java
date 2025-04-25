package org.snap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardGameTest {
    private CardGame cardGame;

    @BeforeEach
    void setUp(){
        cardGame = new CardGame("Snap");
    }

    @Test
    @DisplayName("createDeck populates deckOfCards with 52 cards")
    void createDeck_PopulatesDeck_AddsFiftyTwoCards(){
        assertEquals(52, cardGame.getDeck().size());
    }

    @Test
    @DisplayName("getDeck returns all cards in correct order after creation")
    void getDeck_ReturnsCorrectCards(){
        String firstCard = "(suit: ♥, symbol: A, value: 1)";
        String lastCard = "(suit: ♠, symbol: K, value: 13)";
        assertEquals(firstCard, cardGame.getDeck().get(0).toString());
        assertEquals(lastCard, cardGame.getDeck().get(51).toString());
    }

}
