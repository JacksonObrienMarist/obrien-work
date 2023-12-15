package robot;

import java.util.Scanner;
import java.util.Vector;

public class Robot {
    private int posX;
    private int posY;
    private Direction dir = Direction.NORTH;
    private Vector<String> history;

    void execute(String command) {
        if (command.equals("forward") ) {
            this.forward();
        } else if (command.equals("backward") ) {
            this.backward();
        } else if (command.equals("turn left")) {
            this.turnLeft();
        } else if (command.equals("turn right")) {
            this.turnRight();
        } else if (command.equals("undo")) {
            this.undo();
            return; // returns so it doesnt add undo to the history
        }
        history.add(command);
    }

    void undo () {String previousCommand = history.lastElement();
    if (previousCommand.equals("forward")) {
        this.backward();
    } else if (previousCommand.equals("backward")) {
        this.forward();
    } else if (previousCommand.equals("turn left")) {
        this.turnRight();
    } else if (previousCommand.equals("turn right")) {
        this.turnLeft();
    } history.remove(history.size() - 1);
    }

    void forward() {
        if (dir == Direction.NORTH) posY--;
        else if (dir == Direction.SOUTH) posY++;
        else if (dir == Direction.WEST) posX--;
        else if (dir == Direction.EAST) posX++;
    }

    void backward() {
        if (dir == Direction.NORTH) posY++;
        else if (dir == Direction.SOUTH) posY--;
        else if (dir == Direction.WEST) posX++;
        else if (dir == Direction.EAST) posX--;
    }

    void turnLeft() {
        if (dir == Direction.NORTH) dir = Direction.WEST;
        else if (dir == Direction.SOUTH) dir = Direction.EAST;
        else if (dir == Direction.WEST) dir = Direction.SOUTH;
        else if (dir == Direction.EAST) dir = Direction.NORTH;
    }

    void turnRight() {
        if (dir == Direction.NORTH) dir = Direction.EAST;
        else if (dir == Direction.SOUTH) dir = Direction.WEST;
        else if (dir == Direction.WEST) dir = Direction.NORTH;
        else if (dir == Direction.EAST) dir = Direction.SOUTH;
    }

    public static void main(String[] args) {
        Robot robbie = new Robot();
        Scanner kbd = new Scanner(System.in);
        String command = kbd.nextLine();

        while (!command.equals("quit")) {
            robbie.execute(command);
            System.out.println("Robbie is at (" + robbie.posX + "," + robbie.posY + ") facing " + robbie.dir);
            System.out.println("Enter a command for robbie: ");
            command = kbd.nextLine();
        }
    }

    enum Direction {
        NORTH, SOUTH, WEST, EAST;
    }
}
