/**
* This class is contains a barebones setup for a typical Queue data structure.
*/
import java.util.Optional;

class Queue <T> {

    private Node<T> head;
    private Node<T> tail;

    /**
    * Constructor, initializes the head and tail to null.
    */
    public Queue() {
        this.head = null;
        this.tail = null;
    }

    /**
    * Adds specified value to the end of the Queue
    * @param val Value to be added to the end of the Queue
    */
    void enqueue(T val) {
        Node<T> newNode = new Node<>(val);
        if (this.head == null) {
            this.head = newNode;
        } else {
            this.tail.setNextNode(newNode);
        }
        this.tail = newNode;
    }

    /**
    * Retrieve and removes first Node in the Queue, shifting the
    * second 'highest' Node to be the new head.
    * @return Optional<T> value, which is Optional.empty() if Queue is empty.
    */
    Optional<T> dequeue() {
        if (this.tail == this.head) {
            this.tail = null;
        }
        Optional<T> val = Optional.of(this.head.getVal());
        this.head = this.head.getNextNode();
        return val;
    }

    /**
    * Retrieve the value from the head of Queue without altering the Queue.
    * @return Optional<T> value, which is Optional.empty() if Queue is empty.
    */
    Optional<T> peek() {
        return Optional.of(this.head.getVal());
    }
}
