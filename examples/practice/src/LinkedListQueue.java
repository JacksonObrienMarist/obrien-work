public class LinkedListQueue {
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front, rear;

    public LinkedListQueue() {
        this.front = this.rear = null;
    }

    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        Node temp = front;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return temp.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
        public static void main(String[] args) {
            LinkedListQueue queue = new LinkedListQueue();

            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);

            System.out.println("Dequeued: " + queue.dequeue());
            System.out.println("Dequeued: " + queue.dequeue());

            queue.enqueue(40);
            
            System.out.println("Dequeued: " + queue.dequeue());
            System.out.println("Dequeued: " + queue.dequeue());
            System.out.println("Dequeued: " + queue.dequeue());
        }
    }
