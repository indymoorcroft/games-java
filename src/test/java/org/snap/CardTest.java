package org.snap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {
    private Card card;

    @BeforeEach
    void setUp(){
        card = new Card(Suit.HEARTS, "A", 1);
    }

    @Test
    @DisplayName("toString returns correct card description")
    void toString_CardProperties_ReturnsCorrectDescription () {
        String result = "A ♥";
        assertEquals(result, card.toString());
    }
}
