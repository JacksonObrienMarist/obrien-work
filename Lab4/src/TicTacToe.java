public class TicTacToe {
    public enum Marks {
        X, O, NOTHING
    }

    public static Marks stringToMark(String string) {
        if ("X".equals(string)) {
            return Marks.X;
        } else if ("O".equals(string)) {
            return Marks.O;
        } else {
            return Marks.NOTHING;
        }
    }

    public static String marksToString(Marks mark) {
        if (mark == Marks.X) {
            return "X";
        } else if (mark == Marks.O) {
            return "O";
        } else {
            return " ";
        }
    }
    public static Marks[][] board;

    public static void initializeBoard () {
        board = new Marks[3][3];
        board[0][0] = Marks.X;
        board[1][0] = Marks.O;
        board[2][2] = Marks.X;
        board[1][1] = Marks.X;
        board[0][2] = Marks.O;
    }

    public static void borderPrint() {
        System.out.println("+---+---+---+");
    }

    public static void rowPrint(Marks[] rowNum) {
        System.out.print("| ");
        for (Marks i : rowNum) {
            System.out.print((marksToString(i)) + " | ");
        }
        System.out.println();
    }

    public static void boardPrint() {
        for (int i = 0; i < 3; i++) {
            borderPrint();
            rowPrint(board[i]);
        }
        borderPrint();
    }
    public static void main(String[] args) {
        initializeBoard();
        boardPrint();
    }
}