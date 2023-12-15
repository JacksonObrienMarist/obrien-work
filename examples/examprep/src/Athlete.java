/*  SAMPLE EXAM QUESTION
 *
 * TODO In this file:
 *  #1) Fix all compile-time (i.e., syntax and otherwise) errors.
 *  #2) Fix all logic errors.
 *  #3) Add the missing getter and/or setter methods.
 *  #4) Modify the setters and constructor to enforce the invariants cited before each method.
 *
 * TODO In a separate file:
 *  #1) Use inheritance to create a new class that represents an Athlete from a specific sport.
 *  #2) Include at least one new field that represents some skill element of the sport.
 *  #3) Include a constructor that initializes both this field and the base class.
 *  #4) Include a getter and setter for the new field.
 *  #5) Decide on an invariant property that must hold for the new field (e.g., non-negative,
 *      etc.) and enforce this in your class.
 *  #6) Override the train() method to improve your athlete's skill level by some amount.
 *  #7) Write a main method in your class to test creating and using an instance.
 *
 *  TODO Be sure to run and debug your code in both files to ensure that it is correct.
 *       For extra credit, include Javadoc comments for your new class and all new methods.
 */

/**
 * Base class for athletes in our sports video game series.
 *
 * Invariants:
 *  - the athlete's age must be between 18-100.
 *  - the athlete's name must be non-empty and no longer than 24 characters.
 */
import java.util.Scanner;
public class Athlete {
    private String name;
    private int age;

    /**
     * Create a new athlete with the specified name and age.
     * @param name a name for the new athlete
     * @param age how old is this athlete
     */
    public Athlete(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Get the current age of the athlete.
     * @return age in years
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Change the athlete's age.
     * @param newAge new age in years
     */
    public void setAge(int newAge) {
        this.age = newAge;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * This method intentionally does nothing because an athlete's training is
     * specific to their sport. Override and implement this in each subclass.
     *
     * Ideally, we should make this abstract, but then we couldn't test Athlete in the main method.
     *
     * @param duration how long the athlete trained
     */
    protected void train(int duration) {
        return;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.age + " years old)";
    }

    /**
     * Test the Athlete class.
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        System.out.print("Enter the athlete's last name and age (separated by a space): ");
        String inputName = kbd.next();
        int inputAge = kbd.nextInt();
        Athlete athlete = new Athlete(inputName, inputAge);
        System.out.println(athlete);
    }
}