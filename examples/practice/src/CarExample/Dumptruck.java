package CarExample;

public class Dumptruck {
    private int weight = 2000;
    private double loadCapacity = 1000;


    public double getLoadCapacity() {
        return loadCapacity;
    }

    public int getWeight() {
        return weight;
    }

    public void lowerLoad() {
        System.out.println("Load has been lowered");
    }
    public void raiseLoad() {
        System.out.println("Load has been raised");
    }
}
