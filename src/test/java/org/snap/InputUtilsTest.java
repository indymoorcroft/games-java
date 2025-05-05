package org.snap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputUtilsTest {

    @Test
    @DisplayName("getValidInput returns the input when it is not empty")
    void getValidInput_ValidInput_ReturnsInputIfValid() {
        ByteArrayInputStream in = new ByteArrayInputStream("Indi".getBytes());
        Scanner scanner = new Scanner(in);

        assertEquals("Indi", InputUtils.getValidInput(scanner, "Enter name:"));
}

    @Test
    @DisplayName("getValidInput returns the input when it exists in the validInputs array")
    void getValidInput_ValidInputInArray_ReturnsInputIfValid(){
        ByteArrayInputStream in = new ByteArrayInputStream("y".getBytes());
        Scanner scanner = new Scanner(in);

        assertEquals("y", InputUtils.getValidInput(scanner, "Play Again?", new String[] {"y"}));
    }
}
