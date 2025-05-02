package org.snap;

import java.util.Scanner;

public class Main
{
    public static void main( String[] args )
    {
        Player playerOne = new Player();
        boolean correctInput = false;
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many players?\n1 - One Player\n2 - Two Players\n");

        while(!correctInput){
            String input = scanner.nextLine();

        if(!input.equals("1") && !input.equals("2")){
            System.out.print("Invalid input.\n1 - One Player\n2 - Two Players\n");
        } else {
            correctInput = true;

            playerOne.setName(InputUtils.getValidPlayerName(scanner, "Enter name for Player 1"));

            if(input.equals("2")){
                Player playerTwo = new Player();
                playerTwo.setName(InputUtils.getValidPlayerName(scanner, "Enter name for Player 2"));
                Snap snap = new Snap(playerOne, playerTwo);
                snap.play();
                break;
            }
                Snap snap = new Snap(playerOne, new Player("Computer", true));
                snap.play();
        }
        }
    }
}
