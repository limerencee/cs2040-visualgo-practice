/**
* This class is contains a barebones setup for a typical Hash Table with Separate Chaining structure.
* LinkedList structure is present for each index of the Hash Table.
* Hash Table size of two would yield even hash values for even Keys, and odd hash values for odd Keys.
* This is an undesirable property, as all keys would hash to the same value if they happened to be even.
* If Hash Table size is a power of two, then the hash function simply selects a subset of the Key bits as the table index.
* To obtain a more random scattering, Hash Table size should be a prime number not too close to a power of two.
*/

import java.util.Optional;

class HashTableSC <K, V> {

    private final int MAX_LENGTH = 6007;
    private int tableLength = 0;
    private Node<K, V> table[];

    /**
    * Constructor. Initializes the hashTable array with MAX_LENGTH defined above.
    */
    @SuppressWarnings("unchecked") //Suppress compiler complains of generic array creation
    public HashTableSC() {
        table = new Node[MAX_LENGTH];
    }


    /**
    * Insert specified K-V pair into the table. Hashcode of specified K is calculated
    * with custom hashCode() method. Will not insert if K already exist inside the table.
    * During a collision, append to the end of the LL for that index.
    * @param key Unique identifier for the value to be inserted.
    * @param value Value to be inserted into the hash table.
    * @return true if inserted successfully, false otherwise.
    */
    boolean insert(K key, V value) {

        Node<K, V> newNode = new Node<>(key, value);
        int insertKey = hashCode(key);
        Node<K, V> currentNode = table[insertKey];

        if (insertKey == -1 || tableLength == MAX_LENGTH) { //supplied key is invalid or table is full
            return false;
        }

        if (currentNode == null) { //first entry for the index
            tableLength++;
            table[insertKey] = newNode;
            return true;
        }

        //Traverse the LL until empty slot or duplicate key found.
        while (currentNode.getNextNode() != null && currentNode.getKey() != key) {
            currentNode = currentNode.getNextNode();
        }

        //If empty slot is found, store and return
        if (currentNode.getNextNode() == null) {
            tableLength++;
            currentNode.setNextNode(newNode);
            newNode.setPrevNode(currentNode);
            return true;
        } else { //duplicate key found, do not add
            return false;
        }

    }


    /**
    * Remove value from the table based on input K. Hashcode of specified K is calculated
    * with custom hashCode() method. Will traverse the LL to find a match.
    * @param key Unique identifier for the value to be deleted.
    * @return true if deleted successfully, false otherwise.
    */
    boolean remove(K key) {

        int removeKey = hashCode(key);
        Node<K, V> currentNode = table[removeKey];

        if (removeKey == -1) { //supplied key is invalid
            return false;
        }

        //Traverse LL until key found or end of LL.
        while (currentNode != null) {

            if (currentNode.getKey().equals(key)) { //match found

                if (currentNode.getNextNode() != null) { //if there is a nextNode, adjust the pointers
                    Node<K,V> currentNodeNextNode = currentNode.getNextNode();
                    Node<K,V> currentNodePrevNode = currentNode.getPrevNode();
                    currentNodeNextNode.setPrevNode(currentNodePrevNode); //nextNode points to the current prevNode
                    if (currentNodePrevNode != null) {                  //if prevNode exists, point to the current nextNode
                        currentNodePrevNode.setNextNode(currentNodeNextNode);
                    }
                }
                tableLength--;
                return true;

            }

            currentNode = currentNode.getNextNode();

        }

        return false;

    }


    /**
    * Retrieves value from the table based on input K. Hashcode of specified K is calculated
    * with custom hashCode() method. Will traverse the LL to find a match.
    * @param key Unique identifier for the value to be returned.
    * @return Optional<V> stored with K as identifier. Optional.empty() if not found.
    */
    Optional<V> get(K key) {

        int searchKey = hashCode(key);
        Node<K, V> currentNode = table[searchKey];

        if (searchKey == -1) { //supplied key is invalid
            return Optional.empty();
        }

        //Traverse LL until key found or end of LL.
        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) { //match found
                return Optional.of(currentNode.getValue());
            }

            if (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            } else {
                break;
            }
        }

        return Optional.empty();

    }


    /**
    * Calculates the hashCode of specified K. This is to find which index to store the
    * Node in.
    * @param key Unique identifier to find the hashCode value of.
    * @return Index of the hash table which belongs to input K.
    */
    private int hashCode(K key) {

        try {
            return (int) key % MAX_LENGTH;
        } catch (ClassCastException e) {
            System.out.println("Key is not of type Integer!");
            return -1;
        }

    }


    /**
    * Prints the contents of this hashtable starting from index 0 to MAX_LENGTH.
    * Will also print all the Nodes in each LL.
    */
    void print() {
        for (int i = 0; i < MAX_LENGTH; i++) {
            Node<K, V> currentNode = table[i];
            if (currentNode == null) {
                continue;
            }

            System.out.print("Index[" + i + "] = " + currentNode.getValue());
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
                System.out.print(" <-> " + currentNode.getValue());
            }
            System.out.println();
        }
    }


    /**
    * Returns the number of Nodes stored in the table.
    * @return Number of initialized Node stored in this table.
    */
    int size() {
        return this.tableLength;
    }

}
