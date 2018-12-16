/**
* This class is contains a barebones setup for a typical Stack data structure.
*/
import java.util.Optional;

class Stack <T> {

    private Node<T> head;

    /**
    * Constructor, initializes the head and tail to null.
    */
    public Stack() {
        this.head = null;
    }

    /**
    * Adds specified value to be the new head.
    * @param val Value to be added to top of the stack
    */
    void push(T val) {
        Node<T> newNode = new Node<>(val);
        if (this.head != null) {
            newNode.setNextNode(this.head);
        }
        this.head = newNode;
    }

    /**
    * Retrieve and remove the value from the top of the stack, shifting the
    * second 'highest' Node to be the new head.
    * @return Optional<T> value, which is Optional.empty() if stack is empty.
    */
    Optional<T> pop() {
        if (this.head == null) {
            return Optional.empty();
        }
        Optional<T> val = Optional.of(this.head.getVal());
        this.head = this.head.getNextNode();
        return val;
    }

    /**
    * Retrieve the value from the top of the stack without altering the stack.
    * @return Optional<T> value, which is Optional.empty() if stack is empty.
    */
    Optional<T> peek() {
        return Optional.of(this.head.getVal());
    }
}
