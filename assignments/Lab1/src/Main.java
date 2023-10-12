// Jackson O'Brien - Software Development I
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // This prints a message without a newline ending
        System.out.print("Enter a degree in Celsius: ");
        Scanner scanner = new Scanner(System.in);
        //# We printed a prompt above, so we don't provide a message to input function
        float celsius_degree = scanner.nextFloat(); // Gets the next input line as a float value
        float fahrenheitDegree = (float) ((9.0 /5.0) * celsius_degree + 32);
        System.out.print(celsius_degree + " Celsius is " + fahrenheitDegree + " Fahrenheit");
    }
}