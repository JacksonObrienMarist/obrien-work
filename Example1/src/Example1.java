import java.util.Scanner;

public class Example1 {
    //public - meas that any class may access this method
    // static - you don't need an instance of the class to access this method
    // void - this method does not return a value
    // String[] - data type "String array" or "array of Strings"
    public static void main(String[] args) {
        // this program will:
        // 1. read a series of quiz scores from the keyboard
        // 2. Convert each quiz score to a letter grade
        // 3. print the letter grades for all the quiz scores

        // declare and initialize a variable
        Scanner keyboard = new Scanner(System.in);



        // declare a(n) (uninitialized) variable
        int n;
        // assignment statement (since it's the first, initializes the variable)
        n = keyboard.nextInt();
        // assignment statement (assign a value to a variable)
        n = 20;
    }
}
