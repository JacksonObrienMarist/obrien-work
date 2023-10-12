import java.util.Scanner;
import java.util.Random;
public class Lab2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        while (true) {
            printIntro();
            System.out.println("Enter scissor (0), rock (1), paper (2): ");
            int playerValue = scanner.nextInt();
            int computerValue = random.nextInt(3);
            System.out.printf("The computer chose " + choiceNames(computerValue) + " you chose " + choiceNames(playerValue) + calculateGame(playerValue, computerValue));
        }
    }
    public static void printIntro() {
        System.out.println();
        for (int i = 0; i < 31; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println("| ROCK-PAPER-SCISSORS in JAVA |");
        for (int i = 0; i < 31; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    public static String calculateGame(int plrValue, int comValue) {
        if (plrValue == comValue) {
            return (" too, It's a draw.");
        } else if (plrValue == 0 && comValue == 2 || plrValue == 1 && comValue == 0 || plrValue == 2 && comValue == 1)  {
            return (" you win.");
        } else {
            return (" computer Wins.");
        }
    }
    public static String choiceNames(int choice) {
        if (choice == 0) {
            return("Scissor,");
        } else if (choice == 1) {
            return("Rock,");
        } else if (choice == 2) {
            return("Paper,");
        }
        return null;
    }
}