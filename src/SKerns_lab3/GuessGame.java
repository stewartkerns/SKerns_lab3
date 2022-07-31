/*
 * Stewart Kerns
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package SKerns_lab3;

import java.util.Random;       //import the Random class

public class GuessGame {
    //create a field for the range's minimum
    private int rangeMinimum;
    //create a field for the range's maximum
    private int rangeMaximum;
    //create a field for the count of how many times guessed
    private int count;
    //create a field for the target number
    private int target;

    /**
     * The constructor sets the minimum and maximum for the target number, sets
     * the count to 0 and runs the newTarget method to choose a target
     */
    public GuessGame(){
        //Set the minimum value
        rangeMinimum = 1;
        //Set the maximum value
        rangeMaximum = 100;
        //set the count equal to 0
        count = 0;
        //create a new target number
        newTarget();
    }

    /**
     * This method creates a random number in the range of rangeMaximum and
     * rangeMinimum to be the target
     */
    public void newTarget(){
        //Create a Random object
        Random rand = new Random();
        //Set target equal to a random number between the bounds
        target = rand.nextInt((rangeMaximum - rangeMinimum) + 1) +
                rangeMinimum;
    }

    /**
     * This method takes in a number for the guess and returns true if it
     * matches the guess and false if now
     * @param num The number guessed by the user
     * @return boolean of if the number matches the target or not
     */
    public boolean guess(int num){
        if (num == target) {
            //if the number guessed matches the target, return true
            return true;
        }
        //if the number guessed doesn't match the target, return false and
        //display a hint
        else{
            displayHint(num);
            return false;
        }
    }

    /**
     * This method displays a hint to the user on whether their guess was too
     * high or too low
     * @param num The number guessed by the user
     */
    private void displayHint(int num){
        if (num < target){
            //if the number is too low, tell the user that
            System.out.println(num + " is too low.");
        }
        else {
            //if the number is too high, tell the user that
            System.out.println(num + " is too high.");
        }
    }

    /**
     * This method increments the count by 1 and is to be used every time the
     * user guesses
     */
    public void incrementCount(){
        //increment the count
        count++;
    }

    /**
     * This method gets the range minimum and returns it
     * @return int of the rangeMinimum
     */
    public int getRangeMinimum(){
        //return the range minimum
        return rangeMinimum;
    }

    /**
     * This method gets the range maximum and returns it
     * @return int of the rangeMaximum
     */
    public int getRangeMaximum(){
        //return the range maximum
        return rangeMaximum;
    }

    /**
     * This method gets the count of how many times the user has guessed and
     * returns it
     * @return int of the count of how many times guessed
     */
    public int getCount(){
        //return the count
        return count;
    }
}
