package CarExample;

public class Vehicle {

    public int numWheels = 4;
    public double speed;
    public void goBackward() {
        this.speed = this.speed - 10;
    }
    public void goForward() {
        this.speed = this.speed + 10;
    }

    public int getNumWheels() {
        return numWheels;
    }
    public double getSpeed() {
        return speed;
    }

    public static void main(String[] args) {
        Car car1 = new Car();
        car1.goForward();
        System.out.println(car1.getWeight());
        System.out.println(car1.getNumWheels());
        System.out.println(car1.getSpeed());

        Dumptruck dump = new Dumptruck();
        dump.raiseLoad();
    }
}

