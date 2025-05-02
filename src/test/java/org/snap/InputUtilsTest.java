package org.snap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputUtilsTest {

    @Test
    @DisplayName("getValidPlayerName returns the input when it is valid")
    void getValidPlayerName_ValidInput_ReturnsPlayerNameIfValid() {
        ByteArrayInputStream in = new ByteArrayInputStream("Indi".getBytes());
        Scanner scanner = new Scanner(in);

        assertEquals("Indi", InputUtils.getValidPlayerName(scanner, "Enter name:"));
}
}
