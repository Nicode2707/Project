import java.util.Random;
import java.util.Scanner;

public class rock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] choices = {"rock", "paper", "scissors"};
        
        System.out.println("Enter your choice (rock, paper, or scissors): ");
        String userChoice = scanner.nextLine().toLowerCase();
        
        int computerChoiceIndex = random.nextInt(3);
        String computerChoice = choices[computerChoiceIndex];
        
        System.out.println("Computer chose: " + computerChoice);
        
        if (userChoice.equals(computerChoice)) {
            System.out.println("It's a tie!");
        } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                   (userChoice.equals("scissors") && computerChoice.equals("paper")) ||
                   (userChoice.equals("paper") && computerChoice.equals("rock"))) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
        }
        
        scanner.close();
    }
}
