import java.util.*;
public class numberGuess {
    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(100);
        int guess;
        Scanner scn;
        System.out.println("Please guess a number between 1 to 100:");
        guess = scn.nextInt();
        if(guess > number){
            System.out.println("The number is too big");
            System.out.println("The range is now between ");
        }
        else if(guess < number){

        }
        else if(guess > 100){

        }
        else if(guess < 1){

        }
        else if (guess == number){
            System.out.println("congrats you guessed it!");
        }
    }
}
