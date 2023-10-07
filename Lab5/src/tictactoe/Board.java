package tictactoe;

/**
 * Represents a grid of cells for a Tic-Tac-Toe game.
 */
public class Board {
    // State - fields or member variables (or properties or attributes)

    /**
     * Two-dimensional array to hold the marks placed on the board.
     * Notice that this does not appear in the generated JavaDoc;
     * this is because the field is private.
     */
    private Mark[][] cells = new Mark[3][3];

    // Behavior - methods or member functions

    /**
     * Create a new, blank Tic-Tac-Toe board.
     * Each <em>instance</em> of a class is its own separate object.
     * The process of creating a new instance is call <em>instantiation</em>.
     * Use the <code>new</code> keyword to <em>instantiate</em> the Board class.
     */
    public Board() {
        // cells = new Mark[3][3]; // we could initialize field here if we prefer
        for (int rowIndex = 0; rowIndex < cells.length; rowIndex++) {
            for (int colIndex = 0; colIndex < cells.length; colIndex++) {
                cells[rowIndex][colIndex] = Mark.BLANK;
            }
        }
    }

    /**
     * Update a blank cell on the board with a new mark.
     * @param mark the new mark to place on the board
     * @param row_index vertical position of the cell to be marked
     * @param col_index horizontal position of the cell to be marked
     * @return <code>true</code> if the board was marked successfully, <code>false</code> otherwise
     */
    public boolean placeMark(Mark mark, int row_index, int col_index) {
        // verify that the cell is blank before placing the mark
        if (cells[row_index][col_index] == Mark.BLANK) {
            cells[row_index][col_index] = mark;
            return true;
        }
        return false;
    }

    /**
     * Simple test function to make sure that we can create and mark boards.
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        Board board = new Board();  // an instance of the Board class
        Board board1 = board;  // another name for `board`, not a distinct object

        board.placeMark(Mark.EX, 1, 2);     // now the board has one mark
        board1.placeMark(Mark.OH, 1, 1);    // now the board has two marks

        Board board2 = new Board();  // another, distinct instance of the Board class
        board2.placeMark(Mark.EX, 2, 0);    // this board has just one mark

        print(board);
    }

    public static void printBorder() {
        System.out.println("+---+---+---+");
    }

    public static void printRow(Mark[] rowNum) {
        System.out.print("| ");
        for (Mark i : rowNum) {
            System.out.print((i.markToString(i)) + " | ");
        }
        System.out.println();
    }

    public static void print(Board board) {
        for (int i = 0; i < 3; i++) {
            printBorder();
            printRow(board.cells[i]); // Access the cells field of the board object
        }
        printBorder();
    }
}