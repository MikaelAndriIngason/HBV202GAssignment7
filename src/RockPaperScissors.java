import java.util.*;

public class RockPaperScissors {
    public static void main(String[] args) {
        RockPaperScissors game = new RockPaperScissors();
        game.play();
    }

    public void play() {
        // Variables
        int playerScore = 0;
        int computerScore = 0;

        int playerChoice = 0;
        int computerChoice = 0;

        String winner = "";
        String[] choices = {"rock", "paper", "scissors"};

        // Prints the game instructions
        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("Please choose one of the following options:");
        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissors");
        System.out.println("4. Quit");

        // Play the game until the user chooses to quit
        boolean keepPlaying = true;
        while (keepPlaying) {
            Scanner sc = new Scanner(System.in);
            playerChoice = sc.nextInt();

            // Player chooses to quit
            if (playerChoice == 4) {
                System.out.println("Thanks for playing!");
                keepPlaying = false;
                break;
            }

            Random rand = new Random();
            computerChoice = rand.nextInt(3) + 1;

            // Same choice for both players, so it's a tie
            if (playerChoice == computerChoice) {
                winner = "Tie";
            }
            // Player: Rock  -  Computer: Paper
            else if (playerChoice == 1 && computerChoice == 2) {
                winner = "Computer";
                computerScore++;
            }
            // Player: Rock  -  Computer: Scissors
            else if (playerChoice == 1 && computerChoice == 3) {
                winner = "Player";
                playerScore++;
            }
            // Player: Paper  -  Computer: Rock
            else if (playerChoice == 2 && computerChoice == 1) {
                winner = "Player";
                playerScore++;
            }
            // Player: Paper  -  Computer: Scissors
            else if (playerChoice == 2 && computerChoice == 3) {
                winner = "Computer";
                computerScore++;
            }
            // Player: Scissors  -  Computer: Rock
            else if (playerChoice == 3 && computerChoice == 1) {
                winner = "Computer";
                computerScore++;
            }
            // Player: Scissors  -  Computer: Paper
            else if (playerChoice == 3 && computerChoice == 2) {
                winner = "Player";
                playerScore++;
            }
            // Not a valid choice
            else {
                System.out.println("Invalid input. Please try again.");
            }

            // Prints the winner of this round
            System.out.println("You chose " + choices[playerChoice - 1] + " and the computer chose " + choices[computerChoice - 1] + ".\nThe winner of this round is " + winner + "!");
        }

        // Finds the winner of the game
        String overallWinner = "";
        if (playerScore > computerScore) {
            overallWinner = "Player";
        } else if (playerScore < computerScore) {
            overallWinner = "Computer";
        } else {
            overallWinner = "Tie";
        }

        // Prints the final score
        System.out.println("The winner is " + overallWinner + "!" + "\n" + "Player Score: " + playerScore + "\n" + "Computer Score: " + computerScore);
    }
}
