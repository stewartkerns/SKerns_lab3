/*
 * Stewart Kerns
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package SKerns_lab3;

import java.util.Scanner;   //import the Scanner class
/**
 * This program creates a game that tells the user a set of bounds to guess
 * between, gives them hints on which way to guess, and then tells them if they
 * guessed correctly, this can be repeated until they choose to quit
 */
public class Lab3 {

    /**
     * The main method gives the user a welcome message, creates a Scanner
     * object, plays the game, gives the user a goodbye message, and then closes
     * the Scanner object
     * @param args a String array containing the command line arguments
     */
    public static void main(String[] args){
        //Create a Scanner object to take in keyboard input
        Scanner keyboardIn = new Scanner(System.in);
        //display a welcome message
        welcome();
        //play the game until the user chooses not to
        playGame(keyboardIn);
        //display a goodbye message
        goodbye();
        //close the Scanner object
        keyboardIn.close();
    }

    public static void playGame(Scanner keyboardIn){
        //make a do while loop to run the game until the user doesn't want to
        do{
            //declare a boolean to hold if the guess was right or not
            boolean guessBool;
            //Create a new GuessGame object
            GuessGame game = new GuessGame();
            //For formatting clarity
            System.out.println();

            //make a do while loop to run the guessing part of the game until
            //the user guesses the correct number
            do {
                //run the guess method in GuessGame with the guessNum method
                guessBool = game.guess(guessNum(keyboardIn, game));

                //continue to run while the number guessed is incorrect
            } while (!guessBool);
            //print that the user guessed it and how many guesses it took
            System.out.println("\nThat's correct!\nYou guessed " +
                    game.getCount() + " times.");
        //continue to run while the noPlay method is false
        } while(!noPlay(keyboardIn));

    }

    /**
     * This method asks the user if they would like to play again and to type
     * "no" if they no longer want to play
     *
     * @param keyboardIn A Scanner object for reading keyboard input
     * @return boolean of if they answered no or not
     */
    public static boolean noPlay(Scanner keyboardIn){
        //create a final String to match the user input to
        final String stringEnd = "NO";

        //prompt the user on if they want to play again
        System.out.print("\nWould you like to play again? (no to quit): ");
        //absorb the leftover \n from int inputs
        keyboardIn.nextLine();
        //take in the user input and assign it to a String
        String userAnswer = keyboardIn.nextLine();

        //return true if the string input by the user matches
        return userAnswer.equalsIgnoreCase(stringEnd);
    }

    /**
     * This method asks the user to guess a number between the range maximum and
     * minimum until their guess is inside those bounds and then returns their
     * guess once it's valid
     * @param keyboardIn a Scanner object for taking in keyboard input
     * @param game a GuessGame object for reading the max and min from
     * @return int of the number guessed by the user
     */
    public static int guessNum(Scanner keyboardIn, GuessGame game){
        //declare an int to hold the user's guess
        int guess;

        //create a do while loop to ask the user to enter a number until they
        //enter a valid number inside the given range
        do {
            //increment how many times the user has guessed
            game.incrementCount();
            //Ask the user to input a number
            System.out.print("Guess a number between " + game.getRangeMinimum() +
                    " and " + game.getRangeMaximum() + ": ");
            guess = keyboardIn.nextInt();
        } while(guess < game.getRangeMinimum() || guess >
                game.getRangeMaximum());

        //return the user's guess
        return guess;
    }

    /**
     * This method prints a welcome message to the user
     */
    public static void welcome(){
        //print the welcome message
        System.out.println("This is a guessing game where you will guess a " +
                "number\nand I will you if it is too low or too high.\n");
    }

    /**
     * This method prints a goodbye message to the user
     */
    public static void goodbye(){
        //print a goodbye message
        System.out.println("\nThanks for playing!");
    }
}
