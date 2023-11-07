package Simulator;

public class Robot extends Object {
    private String direction;
    private int xPosition;
    private int yPosition;
    private Room room;
    private static String avatar;

    public Robot(Room room, int xPosition, int yPosition, String direction) {
        super("\uD83E\uDD16"); // Call the constructor of the superclass, Object
        this.room = room;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.direction = direction;
        this.avatar = "\uD83E\uDD16";
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