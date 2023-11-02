package Simulator;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("Robot Simulation");
        System.out.println("In this program the user is able to move a robot around within a box");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Width: ");
        int width = scanner.nextInt();
        System.out.println("Height: ");
        int height = scanner.nextInt();

        Room room = new Room(width, height);
        Robot robot = new Robot(room, (int) (Math.random() * (width - 2) + 1), (int) (Math.random() * (height - 2) + 1), "North");

        printInstructions();
        scanner.nextLine();
        room.placeObstacles(robot.getXPosition(), robot.getYPosition());
        room.goalPlace(robot.getXPosition(), robot.getYPosition());
        while (true) {
            if (room.goalReached(robot.getXPosition(), robot.getYPosition())) {
                System.out.println("Robot has reached the goal");
                credits();
                break;
            }
            room.display(robot.getXPosition(), robot.getYPosition(), robot.getDirection());
            System.out.println("The robot is currently facing " + robot.getDirectionName());
            System.out.println("Enter a command: ");
            String command = scanner.nextLine().toLowerCase();

            if (command.equals("quit")) {
                credits();
                break;
            } else {
                checkCommand(command, robot);
            }
        }
    }

    public static void credits() {
        System.out.println("Thanks for using the Robot Simulator!");
        System.out.println("Jackson O'Brien");
        System.out.println("220L");
        System.out.println("Professor Matthew Johnson");
    }

    public static void printInstructions() {
        System.out.println("These are the commands that can be entered:");
        System.out.println("forward, reverse, turn left, turn right, quit");
    }

    public static void checkCommand(String input, Robot robot) {
        switch (input) {
            case "forward":
                System.out.println("Robot has moved forward");
                robot.moveForward();
                break;
            case "reverse":
                System.out.println("Robot has moved backward");
                robot.reverse();
                break;
            case "turn right":
                System.out.println("Robot has turned right");
                robot.turnRight();
                break;
            case "turn left":
                System.out.println("Robot has turned left");
                robot.turnLeft();
                break;
            case "quit":
                credits();
                break;
            default:
                System.out.println("Invalid command entered, please try one from the list");
        }
    }
}
