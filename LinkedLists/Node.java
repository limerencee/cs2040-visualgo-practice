/**
* This class is used to represent a single entity inside a typical (Doubly) LinkedList / Stack / (DE) Queue.
*/
class Node <T> {

    private T val;
    private Node<T> nextNode;
    private Node<T> prevNode;

    /**
    * Constructor, takes in T value and initializes nextNode to be null.
    * @param val New Node's value.
    */
    public Node (T val) {
        this.val = val;
        this.nextNode = null;
        this.prevNode = null;
    }

    /**
    * Getter to get this Node's T.
    * @return Current Node's T value.
    */
    public T getVal() {
        return this.val;
    }

    /**
    * Getter to get this Node's next Node.
    * @return Next Node's reference.
    */
    public Node<T> getNextNode() {
        return this.nextNode;
    }

    /**
    * Getter to get this Node's previous Node.
    * @return Previous Node's reference.
    */
    public Node<T> getPrevNode() {
        return this.prevNode;
    }

    /**
    * Setter to set this Node's T.
    * @param val New T value for this Node.
    */
    public void setVal(T val) {
        this.val = val;
    }

    /**
    * Setter to set this Node's next Node reference.
    * @param nextNode New next Node's reference.
    */
    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    /**
    * Setter to set this Node's previous Node reference.
    * @param prevNode New previous Node's reference.
    */
    public void setPrevNode(Node<T> prevNode) {
        this.prevNode = prevNode;
    }
}
