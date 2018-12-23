class Main {

    public static void main(String[] args) {

        /**
        * LinkedList Demo
        */
        LinkedList<Integer> ll = new LinkedList<>();
        System.out.println("\n=========================================\n");
        System.out.println("Inserting value: 0 into index: 0; " + ll.insert(0, 0));
        System.out.println("Inserting value: 1 into index: 1; " + ll.insert(1, 1));
        System.out.println("Inserting value: 2 into index: 2; " + ll.insert(2, 2));
        System.out.println("Inserting value: 3 into index: 3; " + ll.insert(3, 3));
        System.out.println("Inserting value: 4 into index: 4; " + ll.insert(4, 4));
        System.out.println("Inserting value: 5 into index: 5; " + ll.insert(5, 5));
        System.out.println("Inserting value: 6 into index: 2; " + ll.insert(2, 6));
        System.out.println("\n=========================================\n");
        System.out.println("Current LinkedList: \n");
        for (int i = 0; i < 6; i++) {
            System.out.print(ll.get(i).get() + " -> ");
        }
        System.out.print(ll.get(6).get());
        System.out.println("\n\n=========================================\n");
        System.out.println("Searched for value: 5, index found at: " + ll.search(5));
        System.out.println("\n=========================================\n");
        System.out.println("Removing value at index: 3; " + ll.remove(3));
        System.out.println("\nCurrent LinkedList: \n");
        for (int i = 0; i < 5; i++) {
            System.out.print(ll.get(i).get() + " -> ");
        }
        System.out.print(ll.get(5).get());
        System.out.println("\n\n=========================================\n");
        System.out.println("Removing value: 6; " + ll.remove(ll.search(6)));
        System.out.println("\nCurrent LinkedList: \n");
        for (int i = 0; i < 4; i++) {
            System.out.print(ll.get(i).get() + " -> ");
        }
        System.out.print(ll.get(4).get());
        System.out.println("\n\n=========================================\n");
        System.out.println("Removing head node; " + ll.removeHead());
        System.out.println("\nCurrent LinkedList: \n");
        for (int i = 0; i < 3; i++) {
            System.out.print(ll.get(i).get() + " -> ");
        }
        System.out.print(ll.get(3).get());
        System.out.println("\n\n=========================================\n");
        System.out.println("Reversing LinkedList.");
        ll.reverseRecursive();
        System.out.println("\nCurrent LinkedList: \n");
        for (int i = 0; i < 3; i++) {
            System.out.print(ll.get(i).get() + " -> ");
        }
        System.out.print(ll.get(3).get());

        /**
        * Doubly LinkedList Demo
        */
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        System.out.println("\n\n=========================================\n");
        System.out.println("Inserting value: 0 into index: 0; " + dll.insert(0, 0));
        System.out.println("Inserting value: 1 into index: 1; " + dll.insert(1, 1));
        System.out.println("Inserting value: 2 into index: 2; " + dll.insert(2, 2));
        System.out.println("Inserting value: 3 into index: 3; " + dll.insert(3, 3));
        System.out.println("Inserting value: 4 into index: 4; " + dll.insert(4, 4));
        System.out.println("Inserting value: 5 into index: 5; " + dll.insert(5, 5));
        System.out.println("Inserting value: 6 into index: 2; " + dll.insert(2, 6));
        System.out.println("\n=========================================\n");
        System.out.println("Current Doubly LinkedList: \n");
        for (int i = 0; i < 6; i++) {
            System.out.print(dll.get(i).get() + " <-> ");
        }
        System.out.print(dll.get(6).get());
        System.out.println("\n\n=========================================\n");
        System.out.println("Searched for value: 5, index found at: " + dll.search(5));
        System.out.println("\n=========================================\n");
        System.out.println("Removing value at index: 3; " + dll.remove(3));
        System.out.println("\nCurrent Doubly LinkedList: \n");
        for (int i = 0; i < 5; i++) {
            System.out.print(dll.get(i).get() + " <-> ");
        }
        System.out.print(dll.get(5).get());
        System.out.println("\n\n=========================================\n");
        System.out.println("Removing value: 6; " + dll.remove(dll.search(6)));
        System.out.println("\nCurrent Doubly LinkedList: \n");
        for (int i = 0; i < 4; i++) {
            System.out.print(dll.get(i).get() + " <-> ");
        }
        System.out.print(dll.get(4).get());
        System.out.println("\n\n=========================================\n");
        System.out.println("Removing tail node; " + dll.removeTail());
        System.out.println("\nCurrent Doubly LinkedList: \n");
        for (int i = 0; i < 3; i++) {
            System.out.print(dll.get(i).get() + " <-> ");
        }
        System.out.print(dll.get(3).get());
        /**
        * Stack Demo
        */
        System.out.println("\n\n=========================================\n");
        System.out.println("Bracket Matching Demo: \n");
        System.out.println("\"[]({[]()})()())\" : " + Applications.checkBracketBalance("[]({[]()})()())"));
        System.out.println("\n=========================================\n");
        System.out.println("Postfix Arithmetic Demo: \n");
        System.out.println("\"4.3 5 7 2 3 + - * %\" : " + Applications.postfixArithmetic("4.3 5 7 2 3 + - * %"));

        /**
        * Queue Demo
        */
        Queue<Integer> queue = new Queue<>();
        System.out.println("\n=========================================\n");
        System.out.println("Queue Demo: \n");
        int[] queueInts = {0, 2, 3, 3, 88, 1, 6};
        for (int i = 0; i < queueInts.length; i++) {
            System.out.println("Inserting the value: " + queueInts[i] + " into the queue.");
            queue.enqueue(queueInts[i]);
        }
        System.out.println("\n=========================================\n");
        System.out.print("Dequeuing: ");
        for (int i = 0; i < 6; i++) {
            System.out.print(queue.dequeue().get() + ", ");
        }
        System.out.print(queue.dequeue().get());

        /**
        * DeQueue Demo
        */
        DeQueue<Integer> dequeue = new DeQueue<>();
        System.out.println("\n\n=========================================\n");
        System.out.println("DE-Queue Demo: \n");
        int[] deQueueInts = {4, 5, 3, 6, 2, 7, 1, 8};
        for (int i = 0; i < queueInts.length; i++) {
            System.out.println("Inserting the value: " + deQueueInts[i] + " into head of the queue.");
            dequeue.enqueueHead(deQueueInts[i++]);
            System.out.println("Inserting the value: " + deQueueInts[i] + " into tail of the queue.");
            dequeue.enqueueTail(deQueueInts[i]);
        }
        System.out.println("\n=========================================\n");
        System.out.print("Dequeuing from head: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(dequeue.dequeueHead().get() + ", ");
        }
        System.out.print(dequeue.dequeueHead().get());
        System.out.print("\n\nDequeuing from tail: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(dequeue.dequeueTail().get() + ", ");
        }
        System.out.print(dequeue.dequeueTail().get());
        System.out.println("\n\n=========================================\n");
    }

}
