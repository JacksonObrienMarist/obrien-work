import com.sun.source.tree.BreakTree;
import java.util.Scanner;
public class ControlStatements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String firstName = scanner.next();
        System.out.println("Enter your last name:");
        String lastName = scanner.next();
        System.out.println("Enter your Marist CWID: ");
        int cwid = scanner.nextInt();
        System.out.println("Enter your age (in years): ");
        int age = scanner.nextInt();
        System.out.println("Enter your favorite sport: ");
        String sport = scanner.next();

       checkCWID(cwid);
       checkLastName(lastName);
       checkAge(age);
       System.out.println(checkSport(sport));
    }
    public static String checkCWID(int cwidInput) {
        if (cwidInput % 3 == 0) {
            System.out.println("won a prize!");
        }
        return null;
    }
    public static String checkAge(int age) {
        for (int i = 0; i < age; i++) {
            System.out.println("You're a jolly good fellow!");
        }
        return null;
    }
    public static String checkSport(String sport) {
        String output;
        sport = sport.toLowerCase();
        switch (sport) {
            case "baseball", "soccer":
                output = "I like that sport";
                break;
            default:
                output = "I dont like that sport";
        }
        return output;
    }
    public static String checkLastName(String lastName) {
        char firstLetter = Character.toUpperCase(lastName.charAt(0));
        String [] halfAlphabet = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"};

        boolean done = false;

        for (String s : halfAlphabet) {
            if (s.equals(String.valueOf(firstLetter))) {
                done = true;
                break;
            }
        }
        if (done) {
            System.out.println("Register for slot one");
        } else {
            System.out.println("Register for slot two");
        }
        return null;
    }
}