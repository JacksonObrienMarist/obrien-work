import java.util.Scanner;
import java.util.Random;
public class Simulator {
    public  static void main(String[] args) {
        System.out.println("Robot Simulation");
        System.out.println("In this program the user is able to move a robot around within a box");

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Width: ");
        int width = scanner.nextInt();
        System.out.println("Height: ");
        int height = scanner.nextInt();

        System.out.println("Press enter to begin.");
        enterFunction();

    }

    public static void enterFunction() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void credits() {
        System.out.println("Thanks for using the Robot Simulator!");
        System.out.println("Jackson O'Brien");
        System.out.println("220L");
        System.out.println("Professor Matthew Johnson");
    }
}
