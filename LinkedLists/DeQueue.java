/**
* This class is contains a barebones setup for a typical DE-Queue data structure.
*/
import java.util.Optional;

class DeQueue <T> {

    Node<T> head;
    Node<T> tail;

    /**
    * Constructor, initializes the head and tail to null.
    */
    public DeQueue() {
        this.head = null;
        this.tail = null;
    }

    /**
    * Adds specified value to the start of the Queue
    * @param val Value to be added to the start of the Queue
    */
    void enqueueHead(T val) {
        Node<T> newNode = new Node<>(val);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setNextNode(this.head);
            this.head.setPrevNode(newNode);
        }
        this.head = newNode;
    }

    /**
    * Adds specified value to the end of the Queue
    * @param val Value to be added to the end of the Queue
    */
    void enqueueTail(T val) {
        Node<T> newNode = new Node<>(val);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setPrevNode(this.tail);
            this.tail.setNextNode(newNode);
        }
        this.tail = newNode;
    }

    /**
    * Retrieve and removes first Node in the Queue, shifting the
    * second 'highest' Node to be the new head.
    * @return Optional<T> value, which is Optional.empty() if Queue is empty.
    */
    Optional<T> dequeueHead() {
        if (this.tail == this.head) {
            this.tail = null;
        }
        Optional<T> val = Optional.of(this.head.getVal());
        this.head = this.head.getNextNode();
        this.head.setPrevNode(null);
        return val;
    }

    /**
    * Retrieve and removes last Node in the Queue, shifting the
    * second 'lowest' Node to be the new tail.
    * @return Optional<T> value, which is Optional.empty() if Queue is empty.
    */
    Optional<T> dequeueTail() {
        if (this.tail == this.head) {
            this.head = null;
        }
        Optional<T> val = Optional.of(this.tail.getVal());
        this.tail = this.tail.getPrevNode();
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
