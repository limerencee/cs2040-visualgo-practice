/**
* This class is contains a barebones setup for a typical Doubly LinkedList data structure.
*/
import java.util.Optional;

class DoublyLinkedList <T> {

    private Node<T> head;
    private Node<T> tail;

    /**
    * Constructor, initializes the head and tail to null.
    */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
    * Returns T at specified index in the LinkedList.
    * @param index Index to get T from.
    * @return Optional<T>, otherwise Optional.empty() if not available.
    */
    Optional<T> get(int index) {
        if (index < 0 || this.head == null) {  //invalid index or empty list
            return Optional.empty();
        } else {
            Node<T> currentNode = this.head;
            Node<T> nextNode = currentNode.getNextNode();
            int currentIndex = 0;
            while (currentNode != null) {
                if (currentIndex == index) {
                    return Optional.of(currentNode.getVal());
                }
                currentNode = nextNode;
                nextNode = nextNode.getNextNode();
                currentIndex++;
            }
            return Optional.empty(); //end of list
        }
    }

    /**
    * Searches LinkedList for specified value, returns the index if found, -1 if not found.
    * @param val T value to search for in the LinkedList.
    * @return Index in LinkedList if found, -1 otherwise.
    */
    int search(T val) {
        if (this.head == null) {
            return -1;
        } else {
            Node<T> currentNode = this.head;
            Node<T> nextNode = currentNode.getNextNode();
            int currentIndex = 0;
            while (currentNode != null) {
                if (currentNode.getVal() == val) {
                    return currentIndex;
                }
                currentNode = nextNode;
                nextNode = nextNode.getNextNode();
                currentIndex++;
            }
            return -1; //end of list
        }
    }

    /**
    * Inserts a new T into the specified index.
    * @param index The index of the LinkedList to insert into.
    * @param val T value to insert into the LinkedList.
    * @return True if inserted successfully, false otherwise.
    */
    boolean insert(int index, T val) {
        Node<T> newNode = new Node<>(val);

        if (index < 0) { //invalid index
            return false;
        } else if (index == 0 && this.head == null) { //create head node
            this.head = newNode;
            this.tail = newNode;
            return true;
        } else if (index == 0 && this.head != null) { //push head to index 1
            newNode.setNextNode(this.head);
            this.head.setPrevNode(newNode);
            this.tail = this.head;
            return true;
        } else if (index > 0 && this.head == null) { //invalid index, empty list
            return false;
        } else {
            //Traverse the list until the index is reached
            //or until end of list
            Node<T> currentNode = this.head;
            Node<T> nextNode = currentNode.getNextNode();
            int nextIndex = 1;
            while (nextIndex <= index) {
                if (nextIndex == index) { //if index hits
                    currentNode.setNextNode(newNode);
                    newNode.setPrevNode(currentNode);
                    if (nextNode == null) { //and if index is tail + 1, newNode becomes the new tail
                        this.tail = newNode;
                    } else { //otherwise, newNode will be inserted between currentNode and nextNode
                        newNode.setNextNode(nextNode);
                        nextNode.setPrevNode(newNode);
                    }
                    return true;
                } else if (currentNode == this.tail && nextIndex != index) { //if reached end of list and index not reached
                    return false;
                }
                //Move to next node
                currentNode = nextNode;
                nextNode = nextNode.getNextNode();
                nextIndex++;
            }
            return false; //end of list, invalid index
        }
    }

    /**
    * Removes T from LinkedList from the specified index.
    * @param index The index of the LinkedList to be removed.
    * @return True if removed successfully, false otherwise.
    */
    boolean remove(int index) {
        if (index < 0 || this.head == null) {
            return false;
        } else if (index == 0) {
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.getNextNode();
            }
            return true;
        } else {
            Node<T> currentNode = this.head;
            Node<T> nextNode = currentNode.getNextNode();
            int nextIndex = 1;
            while (nextIndex <= index) {
                if (nextIndex == index) {
                    if (nextNode == this.tail) {
                        this.tail = currentNode;
                    }
                    currentNode.setNextNode(nextNode.getNextNode());
                    nextNode.getNextNode().setPrevNode(currentNode);
                    return true;
                }
                currentNode = nextNode;
                nextNode = nextNode.getNextNode();
                nextIndex++;
            }
            return false; //end of list
        }
    }

    /**
    * Removes the head Node from LinkedList.
    * @return True if removed successfully, false otherwise.
    */
    boolean removeHead() {
        if (this.head != null) {
            if (this.head == this.tail) { //if LinkedList only contains 1 Node
                this.tail = null;
            }
            this.head = this.head.getNextNode();
            this.head.setPrevNode(null);
            return true;
        } else {
            return false;
        }
    }

    /**
    * Removes the tail Node from LinkedList.
    * @return True if removed successfully, false otherwise.
    */
    boolean removeTail() {
        if (this.tail != null) {
            if (this.head == this.tail) { //if LinkedList only contains 1 Node
                this.tail = null;
            }
            this.tail = this.tail.getPrevNode();
            this.tail.setNextNode(null);
            return true;
        } else {
            return false;
        }
    }

    /**
    * Retrieve the value from the top of the stack without altering the stack.
    * @return Optional<T> value, which is Optional.empty() if stack is empty.
    */
    Optional<T> peek() {
        return Optional.of(this.head.getVal());
    }
}
