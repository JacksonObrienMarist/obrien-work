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
        if (front == back) {
            Candy removedCandy = front.candy;
            front = null;
            back = null;
            return removedCandy;
        } else {
            Node current = front;
            while (current.next != back) {
                current = current.next;
            }
            Candy removedCandy = back.candy;
            back = current;
            current.next = null;
            return removedCandy;
        }
    }
    public boolean isEmpty() {
        return front == null;
    }

    public Candy frontCandy() {
        return front.candy;
    }

    public Candy backCandy() {
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
