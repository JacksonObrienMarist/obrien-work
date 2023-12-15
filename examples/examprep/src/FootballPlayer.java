import java.util.Scanner;
public class FootballPlayer extends Athlete{
    private int running;
    public FootballPlayer(String name, int age, int running) {
        super(name, age);
        this.running = running;
    }

    public int getRunning() {
        return running;
    }

    public void setRunning(int newRun) {
        this.running = newRun;
    }

    @Override
    protected void train(int duration) {
        this.running += duration;
    }

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] main) {

        System.out.println("Enter name and age");
        FootballPlayer player = new FootballPlayer("John", 20, 18);
        System.out.println(player);
        System.out.println(player.running);
        player.train(5);
        System.out.println(player.running);
    }
}