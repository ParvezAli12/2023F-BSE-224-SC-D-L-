import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        String[] rps = {"Rock", "Paper", "Scissors"};
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Let's play Rock, Paper, Scissors!");
        System.out.print("Enter your move (Rock, Paper, or Scissors): ");
        String userMove = scanner.nextLine();

        if (!userMove.equalsIgnoreCase("Rock") &&
            !userMove.equalsIgnoreCase("Paper") &&
            !userMove.equalsIgnoreCase("Scissors")) {
            System.out.println("Invalid move. Please choose Rock, Paper, or Scissors.");
            return;
        }

        int computerIndex = random.nextInt(3);
        String computerMove = rps[computerIndex];

        System.out.println("Computer chose: " + computerMove);

        if (userMove.equalsIgnoreCase(computerMove)) {
            System.out.println("It's a tie!");
        } else if (
            (userMove.equalsIgnoreCase("Rock") && computerMove.equals("Scissors")) ||
            (userMove.equalsIgnoreCase("Paper") && computerMove.equals("Rock")) ||
            (userMove.equalsIgnoreCase("Scissors") && computerMove.equals("Paper"))
        ) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
        }
    }
}
