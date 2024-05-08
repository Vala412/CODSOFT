import java.util.*;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Number Game!!");
        System.out.println("Enter a number between 1-100");
        System.out.println("You have 5 chances to guess the number.");

        boolean guessCorrect = false, playAgain = true;
        int score = 0;

        while (playAgain) {

            Random random = new Random();
            int randomNumber = random.nextInt(100);
            // System.out.println(randomNumber);
            
            for(int i=0; i<5; i++){

                System.out.println("Enter your guess: ");
                int guessNumber = sc.nextInt();
        
                if (guessNumber > randomNumber) {
                    System.out.println("Number is too high. Try again");
                }
                else if (guessNumber < randomNumber) {
                    System.out.println("Number is too low. Try agian");
                } else {
                    System.out.println("Congratualtions!! your guess is correct.");
                    guessCorrect = true;
                    score++;
                    break;
                }
               }
        
               if (!guessCorrect) {
                System.out.println("Sorry!!, you have exhausted all your chances. The correct number was: " + randomNumber);
            }

            System.out.println("Your score is: " + score);
        
            System.out.println("Do you want to play again? (yes/no):");
            String playAgainInput = sc.next();
        
            if (playAgainInput.equalsIgnoreCase("yes")) {
                playAgain = true;
            } else {
                playAgain = false;
            }
        }
    }
}