/**
* This class is contains a barebones setup for a typical Binary Search Tree with no balancing features.
*/
import java.util.Comparator;
import java.util.Optional;

class BinarySearchTree <T> {

    private int treeSize = 0;
    private Node<T> root;
    private Comparator comparator;

    /**
    * Constructor. Initializes the tree's root to specified input.
    * @param root User specified Node to be used as root.
    */
    public BinarySearchTree(Node<T> root) {
        this.root = root;
        this.comparator = Comparator.naturalOrder();
    }

    /**
    * Constructor. Initializes the tree's root to specified input and using a custom comparator.
    * @param root User specified Node to be used as root.
    * @param comparator Custom comparator for sorting Nodes within the tree.
    */
    public BinarySearchTree(Node<T> root, Comparator comparator) {
        this.root = root;
        this.comparator = comparator;
    }

    /**
    * Constructor. Initializes the tree's root to null and using a custom comparator.
    * @param comparator Custom comparator for sorting Nodes within the tree.
    */
    public BinarySearchTree(Comparator comparator) {
        this.root = null;
        this.comparator = comparator;
    }

    /**
    * Constructor. Initializes the tree's root to null and using natural comparator.
    */
    public BinarySearchTree() {
        this.root = null;
        this.comparator = Comparator.naturalOrder();
    }

    /**
    * Returns this tree's root.
    * @return This tree's root Node.
    */
    public Node<T> getRoot() {
        return this.root;
    }


    /**
    * Inserts specified value into the tree.
    * @return true if inserted successfully, false otherwise.
    */
    boolean insert(T newVal) {

        Node<T> newNode = new Node<>(newVal);
        if (this.root == null) {

            this.root = newNode;
            treeSize++;
            return true;

        } else {

            Node<T> currentNode = this.root;
            while (currentNode != null) {

                int x = comparator.compare(currentNode.getValue(), newVal);

                if (x < 0) { //currentNode < newVal, insert RIGHT of current

                    if (currentNode.getRightChild() == null) {
                        currentNode.setRightChild(newNode);
                        break;
                    } else {
                        currentNode = currentNode.getRightChild();
                    }

                } else if (x > 0) { //currentNode > newVal, insert LEFT of current

                    if (currentNode.getLeftChild() == null) {
                        currentNode.setLeftChild(newNode);
                        break;
                    } else {
                        currentNode = currentNode.getLeftChild();
                    }

                } else { //currentNode == newVal, do not add duplicates

                    return false;

                }

            }

            newNode.setParent(currentNode);
            treeSize++;
            recomputeHeight(currentNode); //recalculate height for all parents until root.
            return true;

        }

    }


    /**
    * Removes specified value from the tree.
    * @return true if removed successfully, false otherwise.
    */
    boolean remove (T removeVal) {

        if (this.root == null) {

            return false;

        } else {

            Node<T> currentNode = search(removeVal);
            if (currentNode == null) { //value not found

                return false;

            } else {

                Node<T> currentNodeParent = currentNode.getParent();
                if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) { //currentNode is a leaf

                    if (currentNodeParent == null) { //No parentNode means currentNode is root.
                        this.root = null;
                        return true;
                    }

                    //Remove parentNode's reference to currentNode
                    if (currentNodeParent.getLeftChild() != null && currentNodeParent.getLeftChild().equals(currentNode)) {
                        currentNodeParent.setLeftChild(null);
                    } else if (currentNodeParent.getRightChild() != null && currentNodeParent.getRightChild().equals(currentNode)) {
                        currentNodeParent.setRightChild(null);
                    }

                } else if (currentNode.getLeftChild() != null && currentNode.getRightChild() == null) { //currentNode only has leftChild

                    Node<T> leftChild = currentNode.getLeftChild();
                    leftChild.setParent(currentNodeParent);
                    if (currentNodeParent != null) { //No parentNode means currentNode is root.
                        if (currentNodeParent.getLeftChild() != null && currentNodeParent.getLeftChild().equals(currentNode)) { //check if currentNode is left or right child of currentNodeParent, then link the currentNodeParent to the new left or right child
                            currentNodeParent.setLeftChild(leftChild);
                        } else {
                            currentNodeParent.setRightChild(leftChild);
                        }
                    }

                } else if (currentNode.getLeftChild() == null && currentNode.getRightChild() != null) { //currentNode only has rightChild

                    Node<T> rightChild = currentNode.getRightChild();
                    rightChild.setParent(currentNodeParent);
                    if (currentNodeParent != null) { //No parentNode means currentNode is root.
                        if (currentNodeParent.getRightChild() != null && currentNodeParent.getRightChild().equals(currentNode)) { //check if currentNode is left or right child of currentNodeParent, then link the currentNodeParent to the new left or right child
                            currentNodeParent.setRightChild(rightChild);
                        } else {
                            currentNodeParent.setLeftChild(rightChild);
                        }
                    }

                } else if (currentNode.getLeftChild() != null && currentNode.getRightChild() != null) { //currentNode is an interal vertex

                    Optional<T> successorVal = successor(currentNode.getValue()); //find the in-order successor to currentNode
                    if (!successorVal.isEmpty()) {
                        remove(successorVal.get()); //remove the successor in the bst
                        currentNode.setValue(successorVal.get()); //replace currentNode's val with successorVal
                    } else { //no successor
                        return false;
                    }

                }

                treeSize--;
                recomputeHeight(currentNodeParent); //recalculate height for all parents until root.
                return true;

            }

        }

    }


    /**
    * Recalculates the height for all parents up till root upon insert or delete.
    * @param parentNode initial parent of the affected Node.
    */
    private void recomputeHeight(Node<T> parentNode) {
        if (parentNode == null) {
            return;
        } else {
            parentNode.setHeight(height(parentNode));
            recomputeHeight(parentNode.getParent());
        }
    }


    /**
    * Retrieves the Node that contains specified searchVal.
    * @param searchVal Value to be searched for.
    * @return Node which contains the searchVal, null if searchVal not found.
    */
    Node<T> search(T searchVal) {

        Node<T> currentNode = this.root;
        while (currentNode != null) {

            int x = comparator.compare(currentNode.getValue(), searchVal);

            if (x < 0) { //currentNode < searchVal, traverse RIGHT

                if (currentNode.getRightChild() != null) {
                    currentNode = currentNode.getRightChild();
                } else { //no more right child, searchVal not found in tree.
                    return null;
                }

            } else if (x > 0) { //currentNode > searchVal, traverse LEFT

                if (currentNode.getLeftChild() != null) {
                    currentNode = currentNode.getLeftChild();
                } else { //no more left child, searchVal not found in tree.
                    return null;
                }

            } else {

                return currentNode;

            }

        }

        return null;

    }


    /**
    * Finds the minimum value in the tree.
    * @return Minimum value in Optional.of(), Optional.empty() if empty tree.
    */
    Optional<T> findMin() {

        Node<T> currentNode = root;
        if (currentNode == null) {
            return Optional.empty();
        }

        while (currentNode.getLeftChild() != null) {
            currentNode = currentNode.getLeftChild();
        }

        return Optional.of(currentNode.getValue());

    }


    /**
    * Finds the maximum value in the tree.
    * @return Maximum value in Optional.of(), Optional.empty() if empty tree.
    */
    Optional<T> findMax() {

        Node<T> currentNode = root;
        if (currentNode == null) {
            return Optional.empty();
        }

        while (currentNode.getRightChild() != null) {
            currentNode = currentNode.getRightChild();
        }

        return Optional.of(currentNode.getValue());

    }


    /**
    * Determine the predecessor value of specified value. Predecessor = previous largest value.
    * @param searchVal Value to search the predecessor of.
    * @return Predecessor value in Optional.of(), Optional.empty() if searchVal or no predecessor found.
    */
    Optional<T> predecessor(T searchVal) {

        Node<T> searchNode = search(searchVal);
        if (searchNode == null) { //value not found
            return Optional.empty();
        }

        if (searchNode.getLeftChild() != null) { //if searchNode has a left subtree, find the maximum from it.

            Node<T> currentNode = searchNode.getLeftChild();
            while (currentNode.getRightChild() != null) {
                currentNode = currentNode.getRightChild();
            }

            return Optional.of(currentNode.getValue());

        } else { //else traverse the ancestors of searchVal until a 'left turn' is found. i.e. currentNode is parentNode's right child instead of left child

            Node<T> currentNode = searchNode;
            Node<T> parentNode = searchNode.getParent();

            while (parentNode != null && parentNode.getLeftChild().equals(currentNode)) {
                currentNode = parentNode;
                parentNode = parentNode.getParent();
            }

            if (parentNode == null) { //since there is no right subtree for currentNode, and if there are no parentNode, it means there is no larger value
                return Optional.empty();
            } else {
                return Optional.of(parentNode.getValue());
            }

        }

    }


    /**
    * Determine the successor value of specified value. Successor = next larger value.
    * @param searchVal Value to search the successor of.
    * @return Successor value in Optional.of(), Optional.empty() if searchVal or no successor found.
    */
    Optional<T> successor(T searchVal) {

        Node<T> searchNode = search(searchVal);
        if (searchNode == null) { //value not found
            return Optional.empty();
        }

        if (searchNode.getRightChild() != null) { //if searchNode has a right subtree, find the minimum from it

            Node<T> currentNode = searchNode.getRightChild();
            while (currentNode.getLeftChild() != null) {
                currentNode = currentNode.getLeftChild();
            }

            return Optional.of(currentNode.getValue());

        } else { //else traverse the ancestors of searchVal until a 'right turn' is found. i.e. currentNode is parentNode's left child instead of right child.

            Node<T> currentNode = searchNode;
            Node<T> parentNode = searchNode.getParent();
            while (parentNode != null && parentNode.getRightChild().equals(currentNode)) {
                currentNode = parentNode;
                parentNode = parentNode.getParent();
            }

            if (parentNode == null) { //since there is no right subtree for currentNode, and if there are no parentNode, it means there is no larger value
                return Optional.empty();
            } else {
                return Optional.of(parentNode.getValue());
            }

        }

    }


    /**
    * Determine the k-rank of a Node from the tree. Where k = smallest value Node (1-indexed).
    * @param searchVal Value to search the k-rank of.
    * @return k-th rank of the value, -1 if searchVal not found.
    */
    int rank(T searchVal) {

        if (this.root == null) { //empty tree
            return -1;
        }

        int rank = 1; //1-indexed, change to 0 for 0-indexed rank
        Node<T> currentNode = this.root;
        while (currentNode != null) {

            int x = comparator.compare(currentNode.getValue(), searchVal);

            if (x < 0) { //if currentNode < searchVal, size of left subtree + 1 (currentNode) = rank and set currentNode to currentNode's right child

                rank += 1 + size(currentNode.getLeftChild());
                currentNode = currentNode.getRightChild();

            } else if (x > 0) { //if currentNode > searchVal, set currentNode to currentNode's left child

                currentNode = currentNode.getLeftChild();

            } else { //match found, return current rank + size of left subtree.

                return rank + size(currentNode.getLeftChild());

            }

        }

        return -1; //searchVal not found

    }


    /**
    * Get the k-th rank Node from the tree. Where k = smallest value Node (1-indexed).
    * @param k = k-th rank smallest value Node (1-indexed)
    * @return Node's value in Optional.of(), Optional.empty() if k-th rank not found.
    */
    Optional<T> select(int k) {

        Node<T> currentNode = this.root;
        while (currentNode != null) {
            int currentRank = rank(currentNode.getValue());
            if (currentRank < k) { //currentNode rank is less than input k, search on the right child
                currentNode = currentNode.getRightChild();
            } else if (currentRank > k) { //currentNode rank is more than input k, search on the left child
                currentNode = currentNode.getLeftChild();
            } else { //match found
                return Optional.of(currentNode.getValue());
            }
        }

        return Optional.empty(); //rank not found

    }


    /**
    * Get the size of a (sub-)tree given an input Node, treated as the root.
    * @param subRoot Node to be treated like a root to find the size of the tree.
    * @return Number of Nodes in the tree with subRoot as the tree's root.
    */
    int size(Node<T> subRoot) {

        if (subRoot == null) {
            return 0;
        } else {
            return (size(subRoot.getLeftChild()) + 1 + size(subRoot.getRightChild()));
        }

    }


    /**
    * Calculates the height of the input Node recursively.
    * @return Height of input Node.
    */
    int height(Node<T> currentNode) {

        if (currentNode == null) {
            return -1;
        } else {
            return Math.max(height(currentNode.getLeftChild()), height(currentNode.getRightChild())) + 1;
        }

    }


    /**
    * Prints the current BST in in-order traversal.
    */
    void inorderTraversal(Node<T> currentNode) {

        if (currentNode == null) {
            return;
        }

        //Keep going left all the way.
        inorderTraversal(currentNode.getLeftChild());

        //If no more left, print current Node.
        System.out.print(" -> " + currentNode.getValue() + " (h=" + currentNode.getHeight() + ")");

        //Keep going left for each of the right child.
        inorderTraversal(currentNode.getRightChild());

    }


    /**
    * Prints the current BST in pre-order traversal.
    */
    void preorderTraversal(Node<T> currentNode) {

        if (currentNode == null) {
            return;
        }

        //Print current Node immediately
        System.out.print(" -> " + currentNode.getValue() + " (h=" + currentNode.getHeight() + ")");

        //Keep going left all the way.
        preorderTraversal(currentNode.getLeftChild());

        //Keep going left for each of the right child.
        preorderTraversal(currentNode.getRightChild());

    }


    /**
    * Prints the current BST in post-order traversal.
    */
    void postorderTraversal(Node<T> currentNode) {

        if (currentNode == null) {
            return;
        }

        //Keep going left all the way.
        postorderTraversal(currentNode.getLeftChild());

        //Keep going left for each of the right child.
        postorderTraversal(currentNode.getRightChild());

        //Print current Node
        System.out.print(" -> " + currentNode.getValue() + " (h=" + currentNode.getHeight() + ")");

    }


    /**
    * Overloaded method to print the different traversal paths.
    */
    void inorderTraversal() {
        inorderTraversal(this.root);
    }


    /**
    * Overloaded method to print the different traversal paths.
    */
    void preorderTraversal() {
        preorderTraversal(this.root);
    }


    /**
    * Overloaded method to print the different traversal paths.
    */
    void postorderTraversal() {
        postorderTraversal(this.root);
    }

}
