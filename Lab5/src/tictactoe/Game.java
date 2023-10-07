package tictactoe;
import java.util.Scanner;

import static tictactoe.Board.print;

public class Game {
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe");
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Would you like to start a new game (Y/N).");
            String letter = scanner.nextLine();
            letter = letter.toUpperCase();
            if (letter.equals("N")) {
                break;
            } else if (letter.equals("Y")) {
                Board board = new Board();
                print(board);
                run = false;
            } else {
                break;
            }
        }
    }
}
