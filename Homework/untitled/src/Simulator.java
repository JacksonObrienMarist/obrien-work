import java.util.Scanner;
import java.util.Random;
public class Simulator {
    public  static void main(String[] args) {
        System.out.println("Robot Simulation");
        System.out.println("In this program the user is able to move a robot around within a box");

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        // takes inputs
        System.out.println("Width: ");
        int width = scanner.nextInt();
        System.out.println("Height: ");
        int height = scanner.nextInt();
        // creates random position
        int xPosition = (int) (Math.random() * (width - 2) + 1);
        int yPosition = (int) (Math.random() * (height - 2) + 1);

        printInstructions();
        scanner.nextLine();

        while (true) {
            System.out.println("Enter a command: ");
            String command = scanner.nextLine().toLowerCase().trim();
            if (command.equals("quit")) {
                credits();
                break;
            } else {
                checkCommand(command);
                robotRoom(width, height, xPosition, yPosition);
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
        for (int i = 0; i < height; i++) {
            for (int z = 0; z < width; z++) {
                if (i == 0 || i == height - 1 || z == 0 || z == height - 1) {
                    System.out.print("#");
                } else if (i == y && z == x) {
                    // checks random coordinate, places "R" there
                    System.out.print("R");
                } else {
                    System.out.print(" ");
                }
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
                break;
            case "reverse":
                System.out.println("Robot has moved backward");
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
}
