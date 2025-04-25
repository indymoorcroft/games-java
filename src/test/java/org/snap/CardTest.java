package org.snap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {
    private Card card;

    @BeforeEach
    void setUp(){
        card = new Card("♥", "A", 1);
    }

    @Test
    @DisplayName("toString returns correct card description")
    void toString_CardProperties_ReturnsCorrectDescription () {
        String result = "(suit: ♥, symbol: A, value: 1)";
        assertEquals(result, card.toString());
    }
}
