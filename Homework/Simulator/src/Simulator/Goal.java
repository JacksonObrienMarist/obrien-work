package Simulator;
import java.util.Random;

public class Goal extends Object {
    private static final String avatar = "\uD83C\uDFF4";
    private int goalX;
    private int goalY;

    public Goal() {
        super(avatar);
    }

    public void place(Object[][] locations, int robotX, int robotY) {
        Random random = new Random();

        do {
            goalX = random.nextInt(locations[0].length);
            goalY = random.nextInt(locations.length);
        } while (locations[goalY][goalX].getSymbol().equals("\u2B1B") ||
                (goalX == robotX && goalY == robotY));

        locations[goalY][goalX] = this;
    }

    public boolean isAtPosition(int x, int y) {
        return goalX == x && goalY == y;
    }
}