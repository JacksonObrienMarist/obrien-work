// an enumeration is a finite set of fixed values
// ex: months of the year, days of the week, set values

enum RPSMove {ROCK, PAPER, SCISSORS}

public class RPS2 {
    public static void main(String[] args) {
        System.out.println("ROCK-PAPER-SCISSORS");
        
        final int SCISSORS = 0, ROCK = 1, PAPER = 2;

        // imagine that we defined userSelection and computerSelection already
        int userSelection = 3, computerSelection = 2;

        // "Magic numbers" are literals that are used in multiple places
        if (userSelection == RPSMove.SCISSORS && computerSelection == RPSMove.PAPER) {
            System.out.println("Your scissors beat my paper!");
        } else if (userSelection == RPSMove.SCISSORS && computerSelection == RPSMove.ROCK) {
            System.out.println("my rock beats your scissors");
        } else if (userSelection == RPSMove.SCISSORS && computerSelection == RPSMove.SCISSORS) {
            System.out.println("Tie");
        } else
            System.out.println("no");
    }
}
