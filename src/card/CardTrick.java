/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;
import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 */
public class CardTrick {
    
    
    public static void main(String[] args)
    {
        Random random = new Random();
        
        Card[] magicHand = new Card[7];
        Card c1=new Card();
        c1.setSuit("diamond");
        c1.setValue(2);
        
        
        for (int i=0; i<magicHand.length; i++)
        {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1);
            c.setSuit(Card.SUITS[random.nextInt(4)]);
            magicHand[i] =c;
        }
        
        Scanner input = new Scanner(System.in);
        System.out.println("Pick a card value (1-13): ");
        int userCardValue = input.nextInt();
        System.out.println("Pick a suit (Hearts, Diamonds, Spades, Clubs): ");
        String userCardSuit = input.next();
        
        Card userCard = new Card();
        userCard.setValue(userCardValue);
        userCard.setSuit(userCardSuit);
        
        boolean found = false;
        for (Card card : magicHand) {
            // Check value first
            if (card.getValue() == userCardValue) {
                // If value matches, check the suit
                if (card.getSuit().equalsIgnoreCase(userCardSuit)) {
                    found = true;
                    break; // Stop searching once a match is found
                }
            }
        }
        
        if (found) {
            System.out.println("Congrats! Your card is in the magic hand!!!!.");
        } else {
            System.out.println("Sorry! your card is not in the magic hand.\nYou picked: "+ userCardValue+" of "+userCardSuit);
            
            System.out.println("\nThe magic hand contained:"); // added extra wanted to debug but i like that it shows me
            for (Card c : magicHand) {
                System.out.print(c.getValue() + " of " + c.getSuit()+",");}
            
            Card luckyCard= new Card(); //from GitHub to add a (hard-coded) Card Object called luckyCard with a card number and suit of your choosing.
            luckyCard.setValue(10);
            luckyCard.setSuit("clubs");
            
}
    }    
}
