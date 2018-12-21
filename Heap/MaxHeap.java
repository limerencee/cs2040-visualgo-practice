import java.util.ArrayList;
import java.util.Comparator;

class MaxHeap <T> {

    private int heapIndex = 0;
    private ArrayList<Node<T>> heap;
    private Node<T> root;
    private Comparator comparator;

    public MaxHeap() {
        this.heap = new ArrayList<>();
        this.root = null;
        this.comparator = Comparator.naturalOrder();
    }

    public MaxHeap(Comparator<T> comparator) {
        this.heap = new ArrayList<>();
        this.root = null;
        this.comparator = comparator;
    }

    /**
    * Inserts specified value into the heap, complying with heap property.
    * @param val T value to be added into the heap.
    */
    @SuppressWarnings("unchecked")
    void insert(T val) {
        Node<T> newNode = new Node<>(val);
        heap.add(heapIndex, newNode);

        if (heapIndex == 0) { //root Node
            root = newNode;
        } else {
            int parentNodeIndex = (heapIndex - 1) / 2;
            int currentNodeIndex = heapIndex;
            Node<T> parentNode = heap.get(parentNodeIndex);

            while (parentNodeIndex > -1) { //check until root Node

                if (comparator.compare(parentNode.getVal(), newNode.getVal()) < 0) { //swap if parentNode < newNode
                    //Swap the nodes
                    swap(currentNodeIndex, parentNodeIndex);

                    //Look upwards
                    currentNodeIndex = parentNodeIndex;
                    parentNodeIndex = (parentNodeIndex - 1) / 2;
                    parentNode = heap.get(parentNodeIndex);
                } else { //no more bubbling
                    break;
                }
            }

            //If root node changed
            if (heap.get(0) == newNode) {
                root = newNode;
            }
        }

        //Increment total Nodes in heap
        heapIndex++;
    }

    /**
    * Checks current input Node's children recursively (if any) to ensure heap property is complied to, otherwise swap
    * the current Node with the child that is bigger than itself. Checks Left child before right child.
    * @param currentIndex Index of the Node to check its children.
    */
    @SuppressWarnings("unchecked")
    void checkChildren(int currentIndex) {
        int leftIndex = currentIndex + 1;
        int rightIndex = currentIndex + 2;
        int biggestIndex = currentIndex;

        //If leftChild is bigger than parent, overwrite biggestIndex with leftIndex
        if (leftIndex < heapIndex && comparator.compare(heap.get(leftIndex).getVal(), heap.get(biggestIndex).getVal()) > 0) {
            biggestIndex = leftIndex;
        }

        //If rightChild is bigger than parent, overwrite biggestIndex with rightIndex
        if (rightIndex < heapIndex && comparator.compare(heap.get(rightIndex).getVal(), heap.get(biggestIndex).getVal()) > 0) {
            biggestIndex = rightIndex;
        }

        //If currentIndex has been overwritten, a swap is necessary between the currentIndex and it's childNode
        if (biggestIndex != currentIndex) {
            swap(currentIndex, biggestIndex);
            checkChildren(biggestIndex);
        }
    }

    /**
    * Retrieves and removes the root Node of the heap. Last index Node becomes the new root, which triggers
    * a checking process to ensure that the heap property is complied to.
    * @return T value of the root of the heap.
    */
    T extractMax() {
        if (heapIndex == 0) {
            return null;
        } else if (heapIndex == 1) {
            return heap.get(0).getVal();
        } else {
            //Save the root Node, overwrite root with last Node
            Node<T> max = heap.get(0);
            Node<T> last = heap.get(heapIndex - 1);
            heap.set(0, last);
            heap.remove(heapIndex - 1);
            heapIndex--;
            checkChildren(0);
            return max.getVal();
        }
    }

    /**
    * Prints out the current heap.
    */
    void printHeap() {
        if (heapIndex == 0) {
            System.out.println("The heap is empty.");
            return;
        }
        System.out.println("Root node value: " + heap.get(0).getVal());
        for (int i = 1; i < heapIndex; i++) {
            Node<T> currentNode = heap.get(i);
            System.out.println("Index: " + i + ", Value: " + currentNode.getVal());
        }
    }

    /**
    * Swaps the 2 Nodes inside the heap.
    * @param one Index of first Node to swap.
    * @param two Index of second Node to swap.
    */
    void swap(int one, int two) {
        Node<T> temp = heap.get(one);
        heap.set(one, heap.get(two));
        heap.set(two, temp);
    }
}
