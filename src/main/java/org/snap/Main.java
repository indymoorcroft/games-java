package org.snap;

import java.util.Scanner;

public class Main
{
    public static void main( String[] args )
    {
        Player playerOne = new Player();
        Snap snap;
        Scanner scanner = new Scanner(System.in);

        String input = InputUtils.getValidInput(scanner, "How many players?\n1 - One Player\n2 - Two Players\n", new String[]{"1", "2"});

        playerOne.setName(InputUtils.getValidInput(scanner, "Enter name for Player 1\n"));

            if(input.equals("2")){
                Player playerTwo = new Player();
                playerTwo.setName(InputUtils.getValidInput(scanner, "Enter name for Player 2\n"));
                snap = new Snap(playerOne, playerTwo);
            } else {
                snap = new Snap(playerOne, new Player("Computer", true));
            }

        snap.play();
        }
    }
