public class Car extends Vehicle {
    int doors = 2;
    public Car(int wheels, String model, int doors) {
        super(wheels, model);
        this.doors = doors;
    }

    @Override
    public void move() {
        System.out.println("Car has moved");
    }
}
