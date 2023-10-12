package tictactoe;

/**
 * Represents various marks that may be placed on a Tic-Tac-Toe board.
 */
public enum Mark {
    /** Indicates an unmarked cell. */
    BLANK,
    /** Indicates a cell marked by player one. */
    EX,
    /** Indicates a cell marked by player two. */
    OH;
    public String markToString(Mark mark) {
        if (mark == Mark.EX) {
            return "x";
        } else if (mark == Mark.OH) {
            return "o";
        } else if (mark == Mark.BLANK) {
            return " "; // mark must be BLANK
        }
        return "?";
    }
    public static Mark stringToMark(String s) {
        if (s.equals("x")) {
            return Mark.EX;
        } else if (s.equals("o")) {
            return Mark.OH;
        }
        return Mark.BLANK;
    }
}



