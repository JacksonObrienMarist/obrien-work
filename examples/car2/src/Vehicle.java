public class Vehicle {
    int wheels;

    String model;

    public Vehicle (int wheels, String model) {
        this.wheels = wheels;
        this.model = model;
    }

    public void move() {
        System.out.println("Moved car");
    }
}
