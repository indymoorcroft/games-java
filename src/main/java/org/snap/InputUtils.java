package org.snap;

import java.util.Scanner;

public class InputUtils {

    public static String getValidPlayerName(Scanner scanner, String prompt) {
        while (true){
            System.out.println(prompt);
            String input = scanner.nextLine();

            try {
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Name cannot be empty.");
                }
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
