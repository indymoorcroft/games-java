package org.snap;

public class Main
{
    public static void main( String[] args )
    {
        Card testCard = new Card("heart", "2", 2);
        System.out.println(testCard.toString());

        CardGame snap = new CardGame("Snap");
        System.out.println(snap.getDeck());
    }
}
