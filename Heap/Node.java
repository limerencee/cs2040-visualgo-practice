/**
* This class is used to represent a single entity inside a typical binary tree.
*/
class Node <T> {

    private T val;
    private Node<T> leftChild;
    private Node<T> rightChild;

    /**
    * Constructor, takes in T value and initializes leftChild and rightChild to be null.
    * @param val New Node's value.
    */
    public Node (T val) {
        this.val = val;
        this.leftChild = null;
        this.rightChild = null;
    }

    /**
    * Getter to get this Node's T.
    * @return Current Node's T value.
    */
    public T getVal() {
        return this.val;
    }

    /**
    * Getter to get this Node's leftChild
    * @return leftChild Node reference.
    */
    public Node<T> getLeftChild() {
        return this.leftChild;
    }

    /**
    * Getter to get this Node's rightChild
    * @return rightChild Node reference.
    */
    public Node<T> getRightChild() {
        return this.rightChild;
    }

    /**
    * Setter to set this Node's T.
    * @param val New T value for this Node.
    */
    public void setVal(T val) {
        this.val = val;
    }

    /**
    * Setter to set this Node's leftChild reference.
    * @param leftChild New leftChild Node reference.
    */
    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    /**
    * Setter to set this Node's rightChild reference.
    * @param rightChild New rightChild Node reference.
    */
    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }
}
