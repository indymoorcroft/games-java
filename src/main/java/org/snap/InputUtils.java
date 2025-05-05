package org.snap;

import java.util.Arrays;
import java.util.Scanner;

public class InputUtils {

    public static String getValidInput(Scanner scanner, String prompt) {
        while (true){
            System.out.print(prompt);
            String input = scanner.nextLine();

            try {
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Input cannot be empty");
                }
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public static String getValidInput(Scanner scanner, String prompt, String[] validInputs) {
    while (true){
        System.out.printf(prompt);
        String input = scanner.nextLine();

        try {
            if (input == null || input.trim().isEmpty() || !Arrays.asList(validInputs).contains(input)) {
                throw new IllegalArgumentException("Invalid input");
            }
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please try again.");
        }
    }
}
}