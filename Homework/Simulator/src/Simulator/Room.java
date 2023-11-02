package Simulator;

class Entity {
    private char symbol;

    public Entity(char symbol) {
        this.symbol = symbol;
    }
    public String toString() {
        return String.valueOf(symbol);
    }
}

public class Room {
    private Entity[][] locations;

    public Room(int width, int height) {
        this.locations = new Entity[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    this.locations[i][j] = new Entity('\u2B1B');
                } else {
                    this.locations[i][j] = new Entity('\u2B1C');
                }
            }
        }
    }
    public Entity[][] getLocations() {
        return locations;
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