package org.snap;

import java.util.Scanner;

public class Main
{
    public static void main( String[] args )
    {
        Player playerOne = new Player();
        boolean correctInput = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many players? Press 1 OR 2");

        while(!correctInput){
            String input = scanner.nextLine();

        if(!input.equals("1") && !input.equals("2")){
            System.out.println("Invalid input. Please enter 1 OR 2");
        } else {
            correctInput = true;

                System.out.println("Enter the name for Player 1");
                String playerOneInput = scanner.nextLine();
                playerOne.setName(playerOneInput);

            if(input.equals("2")){
                System.out.println("Enter the name for Player 2");
                String playerTwoInput = scanner.nextLine();
                Player playerTwo = new Player();
                playerTwo.setName(playerTwoInput);
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
