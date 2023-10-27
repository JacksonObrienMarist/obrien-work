package Lab6;

public class CandyRoll {
    private Node front;
    private Node back;

    public CandyRoll() {
        front = null;
        back = null;
    }

    public void addCandy(Candy newCandy) {
        Node n = new Node(newCandy);
        if (isEmpty()) {
            front = n;
            back = n;
        } else {
            back.next = n;
            back = n;
        }

    }
    public Candy removeCandy() {
        if (isEmpty()) {
            throw new IllegalStateException("CandyRoll is empty");
        }

        Candy removedCandy = front.candy;
        if (front == back) {
            front = null;
            back = null;
        } else {
            front = front.next;
        }
        return removedCandy;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public Candy frontCandy() {
        if (isEmpty()) {
            throw new IllegalStateException("CandyRoll is empty");
        }
        return front.candy;
    }

    public Candy backCandy() {
        if (isEmpty()) {
            throw new IllegalStateException("CandyRoll is empty");
        }
        return back.candy;
    }

    class Node {
        Candy candy;
        Node next;

        Node(Candy candy) {
            this.candy = candy;
            this.next = null;
        }
    }
}
