package org.snap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.snap.SnapUtils.isSnap;
import static org.snap.SnapUtils.snapInput;
import static org.snap.SnapUtils.printSnapWinner;

public class SnapUtilsTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public Player playerOne = new Player("Jane", false);
    public Player playerTwo = new Player("John", false);

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreSystemOut() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("isSnap returns true when the previousCard matches the currentCard")
    void isSnap_CardsMatch_ReturnsTrue(){
        assertTrue(isSnap(new Card(Suit.HEARTS, "A", 1), new Card(Suit.DIAMONDS, "A", 1)));
    }

    @Test
    @DisplayName("isSnap returns false when the previousCard does not match the currentCard")
    void isSnap_CardsDoNotMatch_ReturnsFalse(){
        assertFalse(isSnap(new Card(Suit.HEARTS, "K", 13), new Card(Suit.DIAMONDS, "A", 1)));
    }

    @Test
    @DisplayName("snapInput returns true when the user types 'snap'")
    void snapInput_UserInputsSnap_ReturnsTrue(){
        ByteArrayInputStream in = new ByteArrayInputStream("snap".getBytes());
        Scanner scanner = new Scanner(in);

        assertTrue(snapInput(scanner));
    }

    @Test
    @DisplayName("printSnapWinner prints the correct message when the player is successful")
    void printSnapWinner_PlayerWinsSnap_PrintsMessage(){
        Player currentPlayer = playerOne;

        printSnapWinner(currentPlayer, playerOne, playerTwo, true);

        assertEquals("\nCorrect! Jane wins!\n", outputStream.toString());
    }

    @Test
    @DisplayName("printSnapWinner prints the correct message when the player is not successful")
    void printSnapWinner_PlayerLosesSnap_PrintsMessage(){
        Player currentPlayer = playerOne;

        printSnapWinner(currentPlayer, playerOne, playerTwo, false);

        assertEquals("\nToo slow! Jane loses!\nJohn wins!\n", outputStream.toString());
    }

    @Test
    @DisplayName("printSnapWinner increments the score of the winner")
    void printSnapWinner_PlayerWinsSnap_IncrementsPlayerScore(){
        Player currentPlayer = playerOne;

        printSnapWinner(currentPlayer, playerOne, playerTwo, true);
        assertEquals(1, playerOne.getScore());

        printSnapWinner(currentPlayer, playerOne, playerTwo, false);
        assertEquals(1, playerTwo.getScore());
    }
}
