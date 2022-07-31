package SKerns_lab3;

import java.util.Scanner;

public class Lab3 {

    public static void main(String[] args){
    Scanner keyboardIn = new Scanner(System.in);
    welcome();
    playGame(keyboardIn);
    goodbye();
    keyboardIn.close();
    }

    public static void playGame(Scanner keyboardIn){
        do{
            boolean guessBool;
            GuessGame game = new GuessGame();
            System.out.println();
            do {
                guessBool = game.guess(guessNum(keyboardIn, game));
//                if (guessBool) {
//                    System.out.println("That's correct!\nYou guessed " +
//                           game.getCount() + " times.");
//                }
            } while (!guessBool);
            System.out.println("\nThat's correct!\nYou guessed " +
                    game.getCount() + " times.");
        } while(!noPlay(keyboardIn));

    }

    public static boolean noPlay(Scanner keyboardIn){
        final String stringEnd = "NO";
        System.out.print("\nWould you like to play again? (no to quit): ");
        keyboardIn.nextLine();
        String userAnswer = keyboardIn.nextLine();
        return userAnswer.equalsIgnoreCase(stringEnd);
    }

    public static int guessNum(Scanner keyboardIn, GuessGame game){
        int guess;
        do {
            game.incrementCount();
            System.out.print("Guess a number between " + game.getRangeMinimum() +
                    " and " + game.getRangeMaximum() + ": ");
            guess = keyboardIn.nextInt();
        } while(guess < game.getRangeMinimum() || guess >
                game.getRangeMaximum());
        return guess;
    }

    public static void welcome(){
        System.out.println("This is a guessing game where you will guess a " +
                "number\nand I will you if it is too low or too high.\n");
    }

    public static void goodbye(){
        System.out.println("\nThanks for playing!");
    }
}
