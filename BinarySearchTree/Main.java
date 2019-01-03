class Main {

    public static void main(String[] args) {

        /**
        * Binary Search Tree (non-balancing) Demo
        */
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int arr[] = {10, 3, 2, 1, 15, 13, 14};

        System.out.println("\n=========================================\n");
        System.out.println("Binary Search Tree (non-balancing) Demo:\n");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Inserting " + arr[i] + ": " + bst.insert(arr[i]));
        }
        System.out.println("\n=========================================\n");
        System.out.println("Searching for 1: " + bst.search(1).getValue());
        System.out.println("\n=========================================\n");
        System.out.println("Sucessor of: 10: " + bst.successor(10).get());
        System.out.println("\n=========================================\n");
        System.out.println("Predecessor of: 13: " + bst.predecessor(13).get());
        System.out.println("\n=========================================\n");
        System.out.println("FindMin(): " + bst.findMin().get());
        System.out.println("FindMax(): " + bst.findMax().get());
        System.out.println("\n=========================================\n");
        System.out.println("rank(14): " + bst.rank(14));
        System.out.println("select(4): " + bst.select(4).get());
        System.out.println("\n=========================================\n");
        System.out.println("Tree size: " + bst.size(bst.getRoot()));
        System.out.println("\n=========================================\n");
        System.out.print("In-order traversal:");
        bst.inorderTraversal();
        System.out.println("\n\n=========================================\n");
        System.out.print("Pre-order traversal:");
        bst.preorderTraversal();
        System.out.println("\n\n=========================================\n");
        System.out.print("Post-order traversal:");
        bst.postorderTraversal();
        System.out.println();
        System.out.println("\n=========================================\n");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Removing " + arr[i] + ": " + bst.remove(arr[i]));
        }
        System.out.println("\n=========================================\n");

    }

}
