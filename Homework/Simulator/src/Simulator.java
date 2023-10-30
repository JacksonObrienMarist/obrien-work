import java.util.Scanner;
import java.util.Random;
public class Simulator {

    public static String direction = "North";
    public static int xPosition;
    public static int yPosition;
    public static int width;
    public static int height;
    public static char[][] room;
    public  static void main(String[] args) {
        System.out.println("Robot Simulation");
        System.out.println("In this program the user is able to move a robot around within a box");

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        // takes inputs
        System.out.println("Width: ");
        width = scanner.nextInt();
        System.out.println("Height: ");
        height = scanner.nextInt();
        // creates random position
        xPosition = (int) (Math.random() * (width - 2) + 1);
        yPosition = (int) (Math.random() * (height - 2) + 1);

        printInstructions();
        scanner.nextLine();
        robotRoom(width, height, xPosition, yPosition);

        while (true) {
            System.out.println("Enter a command: ");
            String command = scanner.nextLine().toLowerCase();

            if (command.equals("quit")) {
                credits();
                break;
            } else {
                checkCommand(command);
                direction = updateDirection(command, direction);
                robotRoom(width, height, xPosition, yPosition);
                System.out.println("The robot is currently facing " + direction);
            }
        }
    }
    public static void credits() {
        System.out.println("Thanks for using the Robot Simulator!");
        System.out.println("Jackson O'Brien");
        System.out.println("220L");
        System.out.println("Professor Matthew Johnson");
       
    }
    public static void emptyRoom(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int x = 0; x < width; x++) {
                // if statement checks if the loop is on a border, if so it prints #, if not it prints blank space
                if (i == 0 || i == height - 1 || x == 0 || x == width -1) {
                    System.out.print("#");
                }
                else {
                    System.out.print(" ");
                }

            }
            // spaces down to make rows after loop is done
            System.out.println();
        }
    }
    public static void robotRoom(int width, int height, int x, int y) {

        room = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int z = 0; z < width; z++) {
                if (i == 0 || i == height - 1 || z == 0 || z == width - 1) {
                    room[i][z] = '\u2B1B';
                } else {
                    room[i][z] = '\u2B1C';
                }
            }
        }

        switch (direction) {
            case "North":
                room[y][x] = '\u2191';
                break;
            case "South":
                room[y][x] = '\u2193';
                break;
            case "East":
                room[y][x] = '\u2192';
                break;
            case "West":
                room[y][x] = '\u2190';
                break;

        }
        
        for (int i = 0; i < height; i++) {
            for (int z = 0; z < width; z++) {
                System.out.print(room[i][z]);
            }
            System.out.println();
        }
    }
    public static void printInstructions() {
        System.out.println("These are the commands that can be entered:");
        System.out.println("forward, reverse, turn left, turn right, quit");
    }
    public static void checkCommand(String input) {
        switch (input) {
            case "forward":
                System.out.println("Robot has moved forward");
                moveForward();
                break;
            case "reverse":
                System.out.println("Robot has moved backward");
                reverse();
                break;
            case "turn right":
                System.out.println("Robot has turned right");
                break;
            case "turn left":
                System.out.println("Robot has turned left");
                break;
            case "quit":
                  credits();
                  break;
            default:
                System.out.println("Invalid command entered, please try one from the list");

        }
    }
    public static String updateDirection(String command, String direction) {
        switch (command) {
            case "turn right":
                if (direction.equals("North")) {
                    return "East";
                } else if (direction.equals("East")) {
                    return "South";
                } else if (direction.equals("South")) {
                    return "East";
                } else if (direction.equals("West")) {
                    return "North";
                }
            case "turn left":
                if (direction.equals("North")) {
                    return "West";
                } else if (direction.equals("East")) {
                    return "North";
                } else if (direction.equals("South")) {
                    return "West";
                } else if (direction.equals("West")) {
                    return "South";
                }
                break;
        }
        return direction;
    }
    public static void moveForward() {
        switch (direction) {
            case "North":
                if (yPosition - 1 > 0) {
                    if (robotRoomCheck(width, height, xPosition, yPosition - 1)) {
                        yPosition--;
                    }
                } else {
                    System.out.println("The robot can't move through walls.");
                }
                break;
            case "South":
                if (yPosition + 1 < height -1) {
                    if (robotRoomCheck(width, height, xPosition, yPosition + 1)) {
                        yPosition++;
                    }
                } else {
                    System.out.println("The robot can't move through walls.");
                }
                break;
            case "East":
                if (xPosition + 1 < width - 1) {
                    if (robotRoomCheck(width, height, xPosition + 1, yPosition)) {
                        xPosition++;
                    }
                } else {
                    System.out.println("The robot can't move through walls.");
                }
                break;
            case "West":
                if (xPosition - 1 > 0) {
                    if (robotRoomCheck(width, height, xPosition - 1, yPosition)) {
                        xPosition--;
                    }
                } else {
                    System.out.println("The robot can't move through walls.");
                }
                break;
        }
    }
    public static void reverse() {
        switch (direction) {
            case "North":
                if (yPosition + 1 < height - 1) {
                    if (robotRoomCheck(width, height, xPosition, yPosition + 1)) {
                        yPosition++;
                    }
                } else {
                    System.out.println("The robot can't move through walls.");
                }
                break;
            case "South":
                if (xPosition - 1 > 0) {
                    if (robotRoomCheck(width, height, xPosition, yPosition - 1)) {
                        yPosition--;
                    }
                } else {
                    System.out.println("The robot can't move through walls.");
                }
                break;
            case "East":
                if (xPosition - 1 > 0) {
                    if (robotRoomCheck(width, height, xPosition - 1, yPosition)) {
                        xPosition--;
                    }
                } else {
                    System.out.println("The robot can't move through walls.");
                }
                break;
            case "West":
                if (xPosition + 1 < width - 1) {
                    if (robotRoomCheck(width, height, xPosition + 1, yPosition)) {
                        xPosition++;
                    }
                } else {
                    System.out.println("The robot can't move through walls.");
                }
                break;
        }
    }
    public static boolean robotRoomCheck(int width, int height, int x, int y) {
        return x!=0 && x != width -1 && y != 0 && y != height -1;
    }
}