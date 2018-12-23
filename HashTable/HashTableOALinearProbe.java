/**
* This class is contains a barebones setup for a typical Hash Table with OA Linear Probing structure.
* Hash Table size of two would yield even hash values for even Keys, and odd hash values for odd Keys.
* This is an undesirable property, as all keys would hash to the same value if they happened to be even.
* If Hash Table size is a power of two, then the hash function simply selects a subset of the Key bits as the table index.
* To obtain a more random scattering, Hash Table size should be a prime number not too close to a power of two.
*/

import java.util.Optional;

class HashTableOALinearProbe <K, V> {

    private final int MAX_LENGTH = 6007;
    private final Node<K, V> deletedNode;
    private int tableLength = 0;
    private Node<K, V> table[];

    /**
    * Constructor. Initializes the hashTable array with MAX_LENGTH defined above.
    */
    @SuppressWarnings("unchecked") //Suppress compiler complains of generic array creation
    public HashTableOALinearProbe() {
        table = new Node[MAX_LENGTH];
        deletedNode = new Node(-1, -1);
    }


    /**
    * Insert specified K-V pair into the table. Hashcode of specified K is calculated
    * with custom hashCode() method. Will not insert if K already exist inside the table.
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

        //Loop until empty slot, duplicate key, or deleted slot found.
        while (currentNode != null && currentNode.getKey() != key && currentNode != deletedNode) {
            insertKey++;
            insertKey %= MAX_LENGTH;
            currentNode = table[insertKey];
        }

        //Increment table length if added successfully.
        if (currentNode == null || currentNode == deletedNode) {
            tableLength++;
            table[insertKey] = newNode;
            return true;
        }

        return false;

    }


    /**
    * Remove value from the table based on input K. Hashcode of specified K is calculated
    * with custom hashCode() method.
    * @param key Unique identifier for the value to be deleted.
    * @return true if deleted successfully, false otherwise.
    */
    boolean remove(K key) {

        int removeKey = hashCode(key);
        int iterations = 0;

        if (removeKey == -1) { //supplied key is invalid
            return false;
        }

        //Traverse until key found.
        while (table[removeKey] != null) {
            if (table[removeKey].getKey() == key) { //remove the matched Node
                table[removeKey] = deletedNode;
                tableLength--;
                return true;
            }
            removeKey++;
            removeKey %= MAX_LENGTH;

            iterations++;
            if (iterations >= tableLength) { //if looped through all possible Nodes
                return false;
            }
        }

        return false;

    }


    /**
    * Retrieves value from the table based on input K. Hashcode of specified K is calculated
    * with custom hashCode() method.
    * @param key Unique identifier for the value to be returned.
    * @return Optional<V> stored with K as identifier. Optional.empty() if not found.
    */
    Optional<V> get(K key) {

        int searchKey = hashCode(key);
        int iterations = 0;

        if (searchKey == -1) { //supplied key is invalid
            return Optional.empty();
        }

        //Loop while current Node is not null and current Node's Key is <= the key to search for
        while (table[searchKey] != null) {

            if (iterations++ == MAX_LENGTH) { //Loop only as many times as table size
                return Optional.empty();
            }

            if (table[searchKey].getKey() == key) { //match found
                return Optional.of(table[searchKey].getValue());
            }

            searchKey++;
            searchKey %= MAX_LENGTH;
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
    */
    void print() {
        for (int i = 0; i < MAX_LENGTH; i++) {
            if (table[i] == null) {
                continue;
            }
            System.out.println("Index[" + i + "] = " + table[i].getValue());
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
