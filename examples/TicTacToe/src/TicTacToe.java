import java.util.Scanner;

/**
 * A basic Tic-Tac-Toe game
 */
public class TicTacToe {
    // TODO Decide what data do we need to deal with in this program?

    // Use an enumeration to represent the marks
    enum Mark { BLANK, EX, OH }

    public static String markToString(Mark mark) {
        if (mark == Mark.EX) {
            return "x";
        } else if (mark == Mark.OH) {
            return "o";
        } else if (mark == Mark.BLANK) {
            return " "; // mark must be BLANK
        }
        return "?";
    }

    // use a 2D array of Marks to represent the board and the array indexes
    //  to represent the row and column position (respectively) of each cell
    static Mark board[][];

    // Use an enumeration to represent each player's turn
    enum Turn { P1, P2 }

    // Use a Turn to represent which player currently has the turn
    static Turn currentPlayer;

    // TODO Still need to decide how to represent result of the game;
    //  that is, who is the winner or is it a draw?

    // TODO Determine what will this program must do... What are the steps involved?
    public static void main(String[] args) {
        // set up the board
        createBoard();
        // set player 1 as current player
        currentPlayer = Turn.P1;
        printBoard();
        // repeat...
        while (true) {
            //    current player marks the board
            placeMark();

            //    show the board
            printBoard();
            //    check for game over
            if (checkGameOver()) {
                break;
            }
            //    if game is over, stop repeating
            //    otherwise, switch turns (other player becomes current player)
            currentPlayer = (currentPlayer == Turn.P1) ? Turn.P2 : Turn.P1;
        }
    }

    static void createBoard() {
        //      make 3x3 two-dimensional array
        board = new Mark[3][3];
        //      initialize all cells to be BLANK
        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            for (int colIndex = 0; colIndex < board.length; colIndex++) {
                board[rowIndex][colIndex] = Mark.BLANK;
            }
        }
    }

    static void printBoard() {
        //      print top border
        printBorder();
        //      print each row with a separator border (last separator is bottom border
        printBorder();
        for (int i = 0; i < board.length; i++) {
            printRow(i);
            printBorder();
        }
    }

    static void printRow(int i) {
        String rowText = "|";
        for (int j = 0; j < board[i].length; j++) {
            rowText += " " + markToString(board[i][j]) + " |";
        }
        System.out.println(rowText);
    }

    static void printBorder() {
        System.out.println("+---+---+---+");
    }

    static void placeMark() {
        // TODO implement this
        //      identify which cell is being marked
        Mark nextMark;
        if (currentPlayer == Turn.P1) {
            //next mark will be EX
            nextMark = Mark.EX; // scope of this variable is restricted to the if-branch
        } else { // must be Turn.P2
            //next mark will be OH
            nextMark = Mark.OH; // scope of this variable is restricted to the else-branch
        }

        Scanner kbd = new Scanner(System.in);
        System.out.println("In which row (1-3) do you want to place your mark? ");
        int rowIndex = kbd.nextInt() - 1;
        System.out.println("In which column (1-3) do you want to place your mark ");
        int colIndex = kbd.nextInt() - 1;
        //      determine which mark is being placed
        if (board[rowIndex][colIndex] == Mark.BLANK) {
            //place mark in desired cell
            board[rowIndex][colIndex] = nextMark;
        }
        //      check that the desired cell is blank
        //      place the mark in the desired cell
    }

    static boolean checkGameOver() {
        // TODO implement this
        //      check if any row is full with the same mark
        Mark prevMark;
        if (currentPlayer == Turn.P1) {
            //next mark will be EX
            prevMark = Mark.EX; // scope of this variable  restricted to the if-branch
        } else { // must be Turn.P2
            //next mark will be OH
            prevMark = Mark.OH; // scope of this variable is restricted to the else-branch
        }
        for (int i = 0; i < 3; i++) {
            int sameCount = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == prevMark) {
                    sameCount++;
                }
            }
            if (sameCount == 3) {
                //game is over, what do we do now?
                System.out.println("Game over");
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            int sameCount = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == prevMark) {
                    sameCount++;
                }
            }
            if (sameCount == 3) {
                //game is over, what do we do now?
                System.out.println("Game over");
                return true;
            }
        }


        //      check if any column is full with the same mark
        //      check if either diagonal is full with the same mark
        return false;
    }
}