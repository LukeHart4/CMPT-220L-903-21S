package base;

public class Main {

    public static void main(String[] args) {
    	// construct a tree
	    BST tree = new BST();
	    // construct root node
	    Node root = new Node(50);

		// populate tree
	    tree.insertNode(root, 30);
		tree.insertNode(root, 20);
		tree.insertNode(root, 40);
		tree.insertNode(root, 70);
		tree.insertNode(root, 60);
		tree.insertNode(root, 80);


		System.out.println("\nPre Order:");
		tree.preOrder(root);
		System.out.println("\nIn Order:");
		tree.inOrder(root);
		System.out.println("\nPost Order:");
		tree.postOrder(root);
		System.out.println("\nBFS: ");
		tree.bfs(root);
		System.out.println("\nDFS: ");
		tree.dfs(root);
		System.out.println("\nDeleting 70 from the bst:");
		tree.deleteNode(root, 70);
		tree.inOrder(root);

		Node target = tree.find(root, 40);

		System.out.println("\nSearching for 40: " + target.value);
		System.out.println("\nHeight of the tree is: " + tree.getHeight(root));
		System.out.println("\nSmallest value: " + tree.getMin(root).value);
		System.out.println("\nLargest value: " + tree.getMax(root).value);
		System.out.println("\nFind the 4th largest: " + tree.nthLargest(root, 4));

	}
}
