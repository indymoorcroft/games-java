package org.snap;

import java.util.Scanner;

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

                if(currentCard == null) {
                    System.out.println("No more cards. It's a draw!");
                    return;
                }

                System.out.println(currentCard);

                if (isSnap(previousCard, currentCard)) {
                    boolean success = snapInput();
                    printWinner(currentPlayer, success);
                    gameOver = true;
                } else {
                    previousCard = currentCard;
                    currentPlayer = (currentPlayer == playerOne) ? playerTwo : playerOne;
                }
            }
            playAgain();
        }
    }

    private void resetGame() {
        resetDeck();
        shuffleDeck();
        System.out.printf("\nHello! It's %s vs %s! The score is %d-%d\nHow to: When two of the same values are drawn on your turn you have 2 seconds to type 'snap' to win!\n", playerOne.getName(), playerTwo.getName(), playerOne.getScore(), playerTwo.getScore());
    }

    private boolean isSnap(Card prevCard, Card currCard) {
        return prevCard != null && currCard.getSymbol().equals(prevCard.getSymbol());
    }

    private boolean snapInput () {
        final String[] result = {null};

        Thread inputThread = new Thread(() -> {
            Scanner snapScanner = new Scanner(System.in);
            String input = snapScanner.nextLine().trim().toLowerCase();
            result[0] = input;
        });

        inputThread.start();

        try {
            inputThread.join(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return "snap".equals(result[0]);
    }

    public void printWinner(Player currentPlayer, boolean success) {
        if(success){
            System.out.printf("\nCorrect! %s wins!\n", currentPlayer.getName());
            currentPlayer.incrementScore();
        } else {
            System.out.printf("\nToo slow! %s loses!\n", currentPlayer.getName());
            Player winner = (currentPlayer == playerOne) ? playerTwo : playerOne;
            winner.incrementScore();
            System.out.println(winner.getName() + " wins!");
        }
    }

    public void playAgain() {
        System.out.print("\nPlay again?\ny - YES\nn - NO\n");

        while(gameOver){
        String input = scanner.nextLine().trim().toLowerCase();

        if(!input.equals("y") && !input.equals("n")){
            System.out.print("\nInvalid input.\nPlay again?\ny - YES\nn - NO\n");
        } else {
            keepPlaying = input.equals("y");
            gameOver = false;
        }
        }

        if(!keepPlaying){
            getOverallWinner();
            //Placeholder
            System.out.printf("Thank you for playing. The final scores:\n%s: %d\n%s: %d", playerOne.getName(), playerOne.getScore(), playerTwo.getName(), playerTwo.getScore());
        }
    }

    public void getOverallWinner(){
        //Get Overall Winner
    }
}

//public List<Animal> getOldestAnimals() {
//    OptionalInt oldestAge = animals
//            .stream()
//            .map(a -> a.getAge())
//            .mapToInt(Integer::intValue)
//            .max();
//
//    List<Animal> oldestAnimals = animals
//            .stream()
//            .filter(a -> a.getAge() == oldestAge.orElse(0))
//            .collect(Collectors.toList());
//    return oldestAnimals;
//}
