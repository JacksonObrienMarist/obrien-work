package Simulator;

public class Robot extends Object {
    private String direction;
    private int xPosition;
    private int yPosition;
    private Room room;
    private static String avatar;

// Doing a node linked list because its dynamic
    class Node {
        String command;
        Node next;

        Node(String command) {
            this.command = command;
            this.next = null;
        }
    }

    private Node front;
    private Node end;



    // Constructor for robot, it extends from object
    public Robot(Room room, int xPosition, int yPosition, String direction) {
        super("\uD83E\uDD16"); // Call the constructor of the superclass, Object
        this.room = room;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.direction = direction;

        this.front = null;
        this.end = null;
    }

    public void setPosition(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    // adds commands to the list
    public void addCommand(String command) {
        Node node = new Node(command);
        if (end == null) {
            front = node;
            end = node;
        } else {
            end.next = node;
            end = node;
        }
    }
    //Removes commands from the list
    public String removeCommand() {
        if (end != null) {
            String command = end.command;

            if (front == end) {
                front = null;
                end = null;
            } else {
                Node node = front;
                while (node.next != end) {
                    node = node.next;
                }
                end = node;
                end.next = null;
            }
            return command;
        } else {
            System.out.println("History empty, you have to enter a command first");
            return null;
        }
    }

    public void undoCommand() {
        if (front != null) {
            String command = removeCommand();
            switch (command) {
                case "forward":
                    reverse();
                    break;
                case "reverse":
                    moveForward();
                    break;
                case "turn left":
                    turnRight();
                    break;
                case "turn right":
                    turnLeft();
                    break;
            }
        }
    }

    public void rewindCommand() {
        String lastDirection = direction;
        Node current = end;
        int initialX = xPosition;
        int initialY = yPosition;

        while (current != null) {
            String command = removeCommand();

            switch (command) {
                case "forward":
                    reverse();
                    break;
                case "reverse":
                    moveForward();
                    break;
                case "turn left":
                    turnRight();
                    lastDirection = direction;
                    break;
                case "turn right":
                    turnLeft();
                    lastDirection = direction;
                    break;
            }
            current = current.next;
        }

        xPosition = initialX;
        yPosition = initialY;
        direction = lastDirection;
    }

    public void enqueue(String command) {
        Node node = new Node(command);
        if (end == null) {
            front = node;
            end = node;
        } else {
            end.next = node;
            end = node;
        }
    }

    public String dequeue() {
        if (front == null) {
            return null;
        }
        String command = front.command;
        front = front.next;
        if (front == null) {
            end = null;
        }
        return command;
    }

    public boolean checkIfEmpty() { // This checks if the list is empty
        return front == null;
    }

    public void batchCommand() { // The batch commands which is a loop that will go through all of the commands
        while (!checkIfEmpty()) {
            String command = dequeue();
            useCommand(command);
        }
    }

    private void useCommand(String command) {
        switch (command) {
            case "forward":
                moveForward();
                break;
            case "reverse":
                reverse();
                break;
            case "turn right":
                turnRight();
                break;
            case "turn left":
                turnLeft();
                break;
        }
    }

    public char getDirection() {
        switch (direction) {
            case "North":
                return '\u2191';
            case "South":
                return '\u2193';
            case "East":
                return '\u2192';
            case "West":
                return '\u2190';

        }
        return 0;
    }
    public String getDirectionName() {
        switch (direction) {
            case "North":
                return "North";
            case "South":
                return "South";
            case "East":
                return "East";
            case "West":
                return "West";
        }
        return null;
    }


    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }
    public String getAvatar() {
        return avatar;
    }

    public void moveForward() {
        switch (direction) {
            case "North":
                if (yPosition - 1 > 0 && !room.isObstacle(xPosition, yPosition - 1)) {
                    yPosition--;

                } else {
                    System.out.println("The robot can't move through walls.");
                }
                break;
            case "South":
                if (yPosition + 1 < room.getLocations().length - 1 && !room.isObstacle(xPosition, yPosition + 1)) {
                    yPosition++;

                } else {
                    System.out.println("The robot can't move through walls.");
                }
                break;
            case "East":
                if (xPosition + 1 < room.getLocations()[0].length - 1 && !room.isObstacle(xPosition + 1, yPosition)) {
                    xPosition++;

                } else {
                    System.out.println("The robot can't move through walls.");
                }
                break;
            case "West":
                if (xPosition - 1 > 0 && !room.isObstacle(xPosition - 1, yPosition)) {
                    xPosition--;

                } else {
                    System.out.println("The robot can't move through walls.");
                }
                break;
        }
    }

    public void reverse() {

        switch (direction) {

            case "North":
                if (yPosition + 1 < room.getLocations().length - 1 && !room.isObstacle(xPosition, yPosition + 1)) {
                    yPosition++;

                } else {
                    System.out.println("The robot can't move through walls.");
                }
                break;
            case "South":
                if (yPosition - 1 > 0 && !room.isObstacle(xPosition, yPosition - 1)) {
                    yPosition--;

                } else {
                    System.out.println("The robot can't move through walls.");
                }
                break;
            case "East":
                if (xPosition - 1 > 0 && !room.isObstacle(xPosition - 1, yPosition)) {
                    xPosition--;
                } else {
                    System.out.println("The robot can't move through walls.");
                }
                break;
            case "West":
                if (xPosition + 1 < room.getLocations()[0].length - 1 && !room.isObstacle(xPosition + 1, yPosition)) {
                    xPosition++;

                } else {
                    System.out.println("The robot can't move through walls.");
                }
                break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case "North":
                direction = "East";
                break;
            case "East":
                direction = "South";
                break;
            case "South":
                direction = "West";
                break;
            case "West":
                direction = "North";
                break;
        }

    }

    public void turnLeft() {
        switch (direction) {
            case "North":
                direction = "West";
                break;
            case "East":
                direction = "North";
                break;
            case "South":
                direction = "East";
                break;
            case "West":
                direction = "South";
                break;
        }
    }
}