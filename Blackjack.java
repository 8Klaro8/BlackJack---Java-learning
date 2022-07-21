import java.util.Random;
import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {


        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");

        //Task 3 – Wait for the user to press enter.
        System.out.println("Press enter whenever you are ready...");
        String userEnter = scan.nextLine();
        checkIfEnter(userEnter);
        

        //Task 4 – Get two random cards.
        //       – Print them: \n You get a \n" + <randomCard> + "\n and a \n" + <randomCard>
        double cardOne = getRandomCardNumber();
        double cardTwo = getRandomCardNumber();
        System.out.println("FIRST CARD:\t" + cardOne + " \nSECOND CARD:\t" + cardTwo);

        System.out.println("\n You get a \n" + drawRandomCard((int)cardOne) + "\n and a \n" + drawRandomCard((int)cardTwo));
        
        
        double total = cardOne + cardTwo;
        System.out.println("Total value of your cards: " + (int)total);

        //Task 5 – Print the sum of your hand value.
        //       – print: your total is: <hand value>
        // int myCurrentValue = getcurrentCardValue(currentCardValue);

        System.out.println("Press enter to see dealer's card.");
        String userEnterContinue = scan.nextLine();
        checkIfEnter(userEnterContinue);


        
        //Task 6 – Get two random cards for the dealer.
        //       – Print: The dealer shows \n" + <first card> + "\nand has a card facing down \n" + <facedown card>
        //       – Print: \nThe dealer's total is hidden

        int dealerCardOne = (int)getRandomCardNumber();
        int dealerCardTwo = (int)getRandomCardNumber();
        int dealersTotal = dealerCardOne + dealerCardTwo;
        System.out.println("Dealers first card: " + drawRandomCard(dealerCardOne) + " and the 2nd is hidden: " + faceDown());


       
        //Task 8 – Keep asking the player to hit or stay (while loop).
        //       1. Every time the player hits
        //             – draw a new card.
        //             – calculate their new total.
        //             – print: (new line) You get a (new line) <show new card>.
        //             - print: your new total is <total>

        //       2. Once the player stays, break the loop. 

        
        //For tasks 9 to 13, see the article: Blackjack Part II. 


        // String answerHitStay = returnIfHitOrStay();
        // while (answerHitStay.equals("hit")){
        //     total = drawNewCard(total);
        //     scan.nextLine();
        // }
        // checkIfHit(answerHitStay, total);


        while (true) {
            String myHitOrStay = hitOrStay();
            if (myHitOrStay.equals("hit")){
                double newRandomValue = getRandomCardNumber();
                String newCard = drawRandomCard((int)newRandomValue);
                System.out.println("Here's your new card: " + newCard);

                total += newRandomValue;
                if (total > 21){
                    System.out.println("Your total: " + total);
                    System.out.println("You lost!");
                    
                    System.exit(0);
                }
               
                System.out.println("And here's your new total: " + total);
            }
            else if (myHitOrStay.equals("stay")){
                break;
            }
        }
        System.out.println("Dealer's card:\n" + drawRandomCard(dealerCardOne) + "\nand\n" + drawRandomCard(dealerCardTwo));
        System.out.println("Waiting for the dealer...");
        while (dealersTotal < 17) {
            dealersTotal += drawForDealer();
        }
        
        System.out.println("Dealer finished...");
        System.out.println("Dealer's end total: " + dealersTotal);

        if (dealersTotal > 21){
            System.out.println("Dealer lost");
        }
        else{
            if (dealersTotal > total) {
                System.out.println("Dealer won!");
            }
            else if(dealersTotal < total){
                System.out.println("You won");
            }
        }
        

         scan.close();

    }

    public static void checkIfEnter(String userEnter) {
            if (userEnter.equals("")){
                System.out.println("Continuing Game...");
                return;
            }
            else{
                while(!userEnter.equals("") || !userEnter.equals("q")){
                    System.out.println("Press enter to continue or press 'q', to quit the game.");
                    userEnter = scan.nextLine();
                    if (userEnter.equals("")){
                        System.out.println("Continuing Game...");
                        break;
                    }
                    else if (userEnter.equals("q")){
                        System.out.println("Quiting game...");
                        System.exit(0);
                    }
                }
            }
            
            return;
        }
    

    /** Task 1 – make a function that returns a random number between 1 and 13
     * Function name – drawRandomCard
     * @return (int)
     *
     * Inside the function:
     *   1. Gets a random number between 1 and 13.
     *   2. Returns a card.
     */

     public static String drawRandomCard(int randomInput) {
        switch(randomInput){
            case 1: return  "   _____\n"+
                            "  |A _  |\n"+ 
                            "  | ( ) |\n"+
                            "  |(_'_)|\n"+
                            "  |  |  |\n"+
                            "  |____V|\n";
            case 2: return  "   _____\n"+              
                            "  |2    |\n"+ 
                            "  |  o  |\n"+
                            "  |     |\n"+
                            "  |  o  |\n"+
                            "  |____Z|\n";
            case 3: return  "   _____\n" +
                            "  |3    |\n"+
                            "  | o o |\n"+
                            "  |     |\n"+
                            "  |  o  |\n"+
                            "  |____E|\n";
            case 4: return  "   _____\n" +
                            "  |4    |\n"+
                            "  | o o |\n"+
                            "  |     |\n"+
                            "  | o o |\n"+
                            "  |____h|\n"; 
            case 5: return  "   _____ \n" +
                            "  |5    |\n" +
                            "  | o o |\n" +
                            "  |  o  |\n" +
                            "  | o o |\n" +
                            "  |____S|\n";
            case 6: return  "   _____ \n" +
                            "  |6    |\n" +
                            "  | o o |\n" +
                            "  | o o |\n" +
                            "  | o o |\n" +
                            "  |____6|\n";
            case 7: return  "   _____ \n" +
                            "  |7    |\n" +
                            "  | o o |\n" +
                            "  |o o o|\n" +
                            "  | o o |\n" +
                            "  |____7|\n";
            case 8: return  "   _____ \n" +
                            "  |8    |\n" +
                            "  |o o o|\n" +
                            "  | o o |\n" +
                            "  |o o o|\n" +
                            "  |____8|\n";
            case 9: return  "   _____ \n" +
                            "  |9    |\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |____9|\n";
            case 10: return "   _____ \n" +
                            "  |10  o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |___10|\n";
            case 11: return "   _____\n" +
                            "  |J  ww|\n"+ 
                            "  | o {)|\n"+ 
                            "  |o o% |\n"+ 
                            "  | | % |\n"+ 
                            "  |__%%[|\n";
            case 12: return "   _____\n" +
                            "  |Q  ww|\n"+ 
                            "  | o {(|\n"+ 
                            "  |o o%%|\n"+ 
                            "  | |%%%|\n"+ 
                            "  |_%%%O|\n";
            case 13: return "   _____\n" +
                            "  |K  WW|\n"+ 
                            "  | o {)|\n"+ 
                            "  |o o%%|\n"+ 
                            "  | |%%%|\n"+ 
                            "  |_%%%>|\n";
            default:
                return "Never print this";

        }
     }

    private static double getRandomCardNumber() {
        double randNum = Math.floor(Math.random() * (1-13));
        return Math.abs(randNum);
    }

    /** Task 2 – make a function that returns a String drawing of the card.
     * Function name – cardString
     * @param cardNumber (int)
     * @return (String)
     *
     * Inside the function:
     *   1. Returns a String drawing of the card.
     */

    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    
    /** Task 7 – make a function that asks the user to hit or stay.
     * Function name – hitOrStay
     * @return (String)
     *
     * Inside the function:
     *   1. Asks the user to hit or stay.
     *   2. If the user doesn't enter "hit" or "stay", keep asking them to try again by printing:
     *      Please write 'hit' or 'stay'
     *   3. Returns the user's option 
     */

     public static String hitOrStay() {
        System.out.println("Enter 'hit' or 'stay'");
        String hitOrStayAnswer = scan.nextLine();
        while( !(hitOrStayAnswer.equals("hit") || hitOrStayAnswer.equals("stay"))){
            System.out.println("Enter 'hit' or 'stay'");
            hitOrStayAnswer = scan.nextLine();
        }

        return hitOrStayAnswer;
     }

     public static int drawForDealer() {
        double randValue = getRandomCardNumber();
        String dealerNewCard = drawRandomCard((int)randValue);
        System.out.println("Dealer's new card: " + dealerNewCard);
        return (int)randValue;
     }
    
   

    // public static void checkIfHit(String answerHitStay, double total) {
    //     double newRandValue = getRandomCardNumber();
    //     String newCard = drawRandomCard((int)newRandValue);
    //     System.out.println("Your new card: " + newCard);
    //     int newTotal = (int)total + (int)newRandValue;
    //     System.out.println("Your new total: " + newTotal);
    //     System.out.println("\nEnter 'Hit' or 'Stay'");

    // }

    // public static int drawNewCard(double total) {
    //     double newRandValue = getRandomCardNumber();
    //     String newCard = drawRandomCard((int)newRandValue);
    //     System.out.println("Your new card: " + newCard);
    //     int newTotal = (int)total + (int)newRandValue;
    //     return newTotal;
    // }
    

}
    

