/**
* This class is used to represent a single entity inside a typical BST
*/
class Node <T> {
    private T value;
    private int height;
    private Node<T> leftChild;
    private Node<T> rightChild;
    private Node<T> parent;

    /**
    * Constructor, takes in T value and initializes the left, right and parent to null.
    * Height is set to 0 as new Nodes are always inserted as leaf.
    * @param value New Node's value.
    */
    public Node(T value) {
        this.value = value;
        this.height = 0;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
    }

    /**
    * Getter to get this Node's T.
    * @return Current Node's T value.
    */
    public T getValue() {
        return this.value;
    }

    /**
    * Getter to get this Node's height.
    * @return Current Node's height.
    */
    public int getHeight() {
        return this.height;
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
    * Getter to get this Node's parent
    * @return parent Node reference.
    */
    public Node<T> getParent() {
        return this.parent;
    }

    /**
    * Setter to set this Node's T.
    * @param value New T value for this Node.
    */
    public void setValue(T value) {
        this.value = value;
    }

    /**
    * Setter to set this Node's height.
    * @param height New height for this Node.
    */
    public void setHeight(int height) {
        this.height = height;
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

    /**
    * Setter to set this Node's parent reference.
    * @param parent New parent Node reference.
    */
    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public String toString() {
        return "Current Node Value: " + this.value;
    }

}
