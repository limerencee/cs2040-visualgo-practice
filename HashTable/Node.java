/**
* This class is used to represent a single entity inside a typical HashMap
*/
class Node<K, V> {

    private K key;
    private V value;
    private Node<K, V> nextNode;
    private Node<K, V> prevNode;

    /**
    * Constructor, takes in K key and V value and initializes the Node.
    * @param key Node's unique identifier.
    * @param value Node's stored value/data.
    */
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.nextNode = null;
        this.prevNode = null;
    }

    /**
    * Getter to get this Node's K.
    * @return Current Node's K value.
    */
    public K getKey() {
        return this.key;
    }

    /**
    * Getter to get this Node's V.
    * @return Current Node's V value.
    */
    public V getValue() {
        return this.value;
    }

    /**
    * Getter to get this Node's next Node.
    * @return Current Node's next Node.
    */
    public Node<K, V> getNextNode() {
        return this.nextNode;
    }

    /**
    * Getter to get this Node's previous Node.
    * @return Current Node's previous Node.
    */
    public Node<K, V> getPrevNode() {
        return this.prevNode;
    }

    /**
    * Setter to set this Node's K.
    * @param key New K for this Node.
    */
    public void setKey(K key) {
        this.key = key;
    }

    /**
    * Setter to set this Node's V.
    * @param value New V for this Node.
    */
    public void setValue(V value) {
        this.value = value;
    }

    /**
    * Setter to set this Node's next Node.
    * @param nextNode New nextNode for this Node.
    */
    public void setNextNode(Node<K, V> nextNode) {
        this.nextNode = nextNode;
    }

    /**
    * Setter to set this Node's previous Node.
    * @param prevNode New prevNode for this Node.
    */
    public void setPrevNode(Node<K, V> prevNode) {
        this.prevNode = prevNode;
    }

}
