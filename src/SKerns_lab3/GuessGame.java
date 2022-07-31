package SKerns_lab3;

import java.util.Random;

public class GuessGame {
    private int rangeMinimum;
    private int rangeMaximum;
    private int count;
    private int target;

    public GuessGame(){
        rangeMinimum = 1;
        rangeMaximum = 100;
        count = 0;
        newTarget();
    }

    public void newTarget(){
        Random rand = new Random();
        target = rand.nextInt((rangeMaximum - rangeMinimum) + 1) +
                rangeMinimum;
    }

    public boolean guess(int num){
        if (num == target) {
            return true;
        }
        else{
            displayHint(num);
            return false;
        }
    }
    private void displayHint(int num){
        if (num < target){
            System.out.println(num + " is too low.");
        }
        else {
            System.out.println(num + " is too high.");
        }
    }
    public void incrementCount(){
        count++;
    }

    public int getRangeMinimum(){
        return rangeMinimum;
    }

    public int getRangeMaximum(){
        return rangeMaximum;
    }

    public int getCount(){
        return count;
    }





}
