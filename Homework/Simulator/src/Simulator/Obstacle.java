package Simulator;

public class Obstacle extends Room {
    private int x;
    private int y;
    private static String avatar = "\uD83E\uDDF1";

    public Obstacle(int width, int height, int x, int y) {
        super(width, height);
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public static String getAvatar() {
        return avatar;
    }
}
