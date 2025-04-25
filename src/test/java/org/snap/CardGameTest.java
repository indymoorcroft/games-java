package org.snap;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CardGameTest {
    private CardGame cardGame;

    @BeforeEach
    void setUp(){
        cardGame = new CardGame("Snap");
    }

    @Test
    @Order(1)
    @DisplayName("createDeck populates deckOfCards with 52 cards")
    void createDeck_PopulatesDeck_AddsFiftyTwoCards(){
        assertEquals(52, cardGame.getDeck().size());
    }

    @Test
    @Order(2)
    @DisplayName("getDeck returns all cards in correct order after creation")
    void getDeck_ReturnsCorrectCards(){
        String firstCard = "(suit: ♥, symbol: A, value: 1)";
        assertEquals(firstCard, cardGame.getDeck().getFirst().toString());

        String lastCard = "(suit: ♠, symbol: K, value: 13)";
        assertEquals(lastCard, cardGame.getDeck().get(51).toString());
    }

    @Test
    @Order(3)
    @DisplayName("sortDeckInNumberOrder returns all cards in number order")
    void sortDeckInNumberOrder_SortsCardsByValue_ReturnsDeck() {
        ArrayList<Card> sortedByNum = cardGame.sortDeckInNumberOrder();

        assertEquals(1, sortedByNum.getFirst().getValue());
        assertEquals(2, sortedByNum.get(4).getValue());
    }

    @Test
    @Order(4)
    @DisplayName("sortDeckIntoSuits returns all cards sorted by suit then number")
    void sortDeckIntoSuits_SortsCardsBySuitThenValue_ReturnsDeck() {
        ArrayList<Card> sortedBySuitAndNum = cardGame.sortDeckIntoSuits();

        assertEquals(1, sortedBySuitAndNum.getFirst().getValue());
        assertEquals("♠", sortedBySuitAndNum.getFirst().getSuit());

        assertEquals(2, sortedBySuitAndNum.get(1).getValue());
        assertEquals("♠", sortedBySuitAndNum.get(1).getSuit());
    }

    @Test
    @Order(5)
    @DisplayName("dealCard returns the first card in the deck")
    void dealCard_DealsTopCard_ReturnsFirstCard() {
        String firstCard = "(suit: ♠, symbol: A, value: 1)";
        assertEquals(firstCard, cardGame.dealCard().toString());
    }

    @Test
    @Order(6)
    @DisplayName("dealCard removes the first card in the deck")
    void dealCard_RemovesCards_FiftyOneCardsRemaining(){
        assertEquals(51, cardGame.getDeck().size());
    }

    @Test
    @Order(7)
    @DisplayName("shuffleDeck changes the orders of the cards")
    void shuffleDeck_ChangesOrder_ReturnsDeck() {
        ArrayList<Card> copy = new ArrayList<>(cardGame.getDeck());
        ArrayList<Card> shuffled = cardGame.shuffleDeck();
        assertNotEquals(copy, shuffled);
    }

    @Test
    @Order(8)
    @DisplayName("dealCard returns null when empty")
    void dealCard_everyCardDealt_ReturnsNull() {
        for(int i = 0; i < 51; i++){
            cardGame.dealCard();
        }
        assertNull(cardGame.dealCard());
    }
}
