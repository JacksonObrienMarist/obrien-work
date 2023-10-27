package Lab6;

public class CandyRollTester {
    public static void main(String args[]) {
        CandyRoll candyRoll = new CandyRoll();

        Candy candy1 = new Candy("Candy1");
        Candy candy2 = new Candy("Candy2");
        Candy candy3 = new Candy("Candy3");
        Candy candy4 = new Candy("Candy4");

        candyRoll.addCandy(candy1);
        candyRoll.addCandy(candy2);
        candyRoll.addCandy(candy3);
        candyRoll.addCandy(candy4);

        Candy removedCandy = candyRoll.removeCandy();
        System.out.println("Removed candy: " + removedCandy.getKind());

        Candy frontCandy = candyRoll.frontCandy();
        System.out.println("Front candy: " + frontCandy.getKind());

        Candy backCandy = candyRoll.backCandy();
        System.out.println("Back candy now: " + backCandy.getKind());

        backCandy = candyRoll.backCandy();

        System.out.println("Back candy: " + backCandy.getKind());

        System.out.println("Is the candy roll empty: " + candyRoll.isEmpty());

        candyRoll.removeCandy();
        candyRoll.removeCandy();
        candyRoll.removeCandy();
        System.out.println("Is the candy roll empty: " + candyRoll.isEmpty());
    }
}
