package org.snap;

import java.util.Scanner;
import static org.snap.SnapUtils.*;

public class Snap extends CardGame {

    boolean keepPlaying = true;
    boolean gameOver = false;
    Scanner scanner = new Scanner(System.in);

    public Snap(Player playerOne, Player playerTwo) {
        super(playerOne, playerTwo);
    }

    @Override
    public void play() {

        while(keepPlaying){
            resetGame();

            Player currentPlayer = playerOne;
            Card previousCard = null;

            while(!deckOfCards.isEmpty() && !gameOver){

                System.out.printf("\n%s's turn. Press ENTER to draw a card.\n", currentPlayer.getName());
                scanner.nextLine();

                Card currentCard = dealCard();

                System.out.println(currentCard);

                if (isSnap(previousCard, currentCard)) {
                    boolean success;
                    if(currentPlayer.isComputer()){
                        success = handleComputerSnap();
                    } else {
                        success = snapInput(scanner);
                    }


                    printSnapWinner(currentPlayer, playerOne, playerTwo, success);
                    gameOver = true;
                } else {
                    previousCard = currentCard;
                    currentPlayer = (currentPlayer == playerOne) ? playerTwo : playerOne;
                }
            }

            if(deckOfCards.isEmpty()) {
                System.out.println("No more cards. It's a draw!");
            }

            playAgain();
        }
    }

    private void resetGame() {
        resetDeck();
        shuffleDeck();
        System.out.printf("\nHello! It's %s vs %s! The score is %d-%d\nHow to: When two of the same values are drawn on your turn you have 2 seconds to type 'snap' to win!\n", playerOne.getName(), playerTwo.getName(), playerOne.getScore(), playerTwo.getScore());
    }

    public void playAgain() {
            String response = InputUtils.getValidInput(scanner, "\nPlay again?\ny - YES\nn - NO\n", new String[] {"y", "n", "Y", "N"});

            if(response.equals("y")){
                gameOver = false;
            } else {
                keepPlaying = false;
                printOverallWinner();
            }
    }

    public void printOverallWinner(){
        if (playerOne.getScore() > playerTwo.getScore()) {
            System.out.printf("Thanks for playing. %s WINS %d:%d", playerOne.getName(), playerOne.getScore(), playerTwo.getScore());
        } else if (playerOne.getScore() < playerTwo.getScore()) {
            System.out.printf("Thanks for playing. %s WINS %d:%d", playerTwo.getName(), playerOne.getScore(), playerTwo.getScore());
        } else {
            System.out.printf("Thanks for playing. It is a draw! %d:%d", playerOne.getScore(), playerTwo.getScore());
        }
    }
}
