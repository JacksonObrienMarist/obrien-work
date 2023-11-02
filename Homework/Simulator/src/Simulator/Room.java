package Simulator;
import java.util.Random;
class Entity {
    private String symbol;

    public Entity(String symbol) {
        this.symbol = symbol;
    }
    public String toString() {
        return String.valueOf(symbol);
    }
    public String getSymbol() {
        return symbol;
    }
}

public class Room {
    private static final String OBSTACLE = Obstacle.getAvatar();
    private Entity[][] locations;
    private Goal goal;
    public Room(int width, int height) {
        this.locations = new Entity[height][width];
        this.goal = new Goal();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    this.locations[i][j] = new Entity("⬛");
                } else {
                    this.locations[i][j] = new Entity("⬜");
                }
            }
        }
    }

    public void goalPlace(int robotX, int robotY) {
        goal.place(locations, robotX, robotY);
    }
    public boolean goalReached(int x, int y) {
        return goal.isAtPosition(x,y);
    }
    public Entity[][] getLocations() {
        return locations;
    }

    public void placeObstacles(int robotX, int robotY) {
        Random random = new Random();
        int totalSpaces = locations.length * locations[0].length;
        int maxNumberOfObstacles = totalSpaces / 10;


        int numberOfObstacles = random.nextInt(maxNumberOfObstacles) + 1;

        while (numberOfObstacles > 0) {
            int x = random.nextInt(locations[0].length);
            int y = random.nextInt(locations.length);

            if (locations[y][x].getSymbol().equals("⬜") && (x != robotX || y != robotY)) {
                locations[y][x] = new Entity(Obstacle.getAvatar());
                numberOfObstacles--;
            }
        }
    }
    public boolean isObstacle(int x, int y) {
        return locations[y][x].getSymbol() == OBSTACLE;
    }

    public void display(int x, int y, char direction) {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                if (i == y && j == x) {
                    System.out.print(direction + " ");
                } else {
                    System.out.print(locations[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}