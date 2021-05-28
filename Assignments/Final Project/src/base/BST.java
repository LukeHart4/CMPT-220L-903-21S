package base;

import java.util.ArrayList;

public class BST {
    //root node
    Node first;

    // Constructor to create an empty bst
    public BST() {
        this.first = null;
    }


    // Method to insert a node into a bst
    Node insertNode(Node root, int value) {
        // construct new node with given value
        Node newNode = new Node(value);
        // keep track of the node we're on
        Node current = root;
        // keep track of current node's parent
        Node parent = null;

        // traverse tree
        while (current != null) {
            // update parent
            parent = current;
            if(value < current.value) {
                // go to the left
                current = current.leftChild;
            }
            // traverse right
            else{
                // go to the right
                current = current.rightChild;
            }
        }
        // tree is empty
        if (parent == null) {
            parent = newNode;
        }
        else if (value < parent.value) {
            // assign new node to left child
            parent.leftChild = newNode;
        }
        else {
            // assign new node to right child
            parent.rightChild = newNode;
        }

        return parent;
    }

    // Method to recursively traverse bst inOrder
    void inOrder (Node root) {
        if (root == null)
            return;
        // visit left
        inOrder(root.leftChild);
        // visit root
        System.out.println(root.value);
        // visit right
        inOrder(root.rightChild);

    }

    // Method to recursively traverse bst preOrder
    void preOrder (Node root) {
        if (root == null)
            return;
        // visit root
        System.out.println(root.value);
        // visit left
        preOrder(root.leftChild);
        // visit right
        preOrder(root.rightChild);
    }

    // Method to recursively traverse bst postOrder
    void postOrder (Node root) {
        if (root == null)
            return;
        // visit left
        postOrder(root.leftChild);
        // visit right
        postOrder(root.rightChild);
        // visit root
        System.out.println(root.value);
    }

    // Method to recursively search for a given node
    public Node find(Node root, int target) {
        // root is the target or the tree is empty
        if (root == null || root.value == target)
            return root;
        // target is smaller, so check the left
        if (root.value > target)
            return find(root.leftChild, target);
        // target is larger, check the right
        return find(root.rightChild, target);
    }

    // Method to get the height of a bst
    public int getHeight(Node root) {
        // empty
        if (root == null)
            return 0;

        // traverse as far left as we can
        int leftHeight = getHeight(root.leftChild);
        // traverse as far right as we can
        int rightHeight = getHeight(root.rightChild);

        // take the larger of the two values
        // plus one for the root node

        if (leftHeight > rightHeight)
            return (leftHeight + 1);
        else
            return (rightHeight + 1);
    }

    // Method to get the minimum value in a bst
    public Node getMin(Node root) {
        // keep track of current node
        Node current = root;
        // traverse as far left as we can (bst so smallest all the way left)
        while (current.leftChild != null) {
            current = current.leftChild;
        }
        // return smallest node
        return current;
    }

    // Method to get maximum value in a bst
    public Node getMax (Node root) {
        // keep track of current node
        Node current = root;
        // traverse as far right as we can
        while (current.rightChild != null) {
            current = current.rightChild;
        }
        // return largest node
        return current;
    }

    // Helper method to put bst in a sorted array list
    // used to help find the nth largest
    void putInOrder(Node root, ArrayList<Integer> values) {
        if (root == null)
            return;
        putInOrder(root.leftChild, values);
        values.add(root.value);
        putInOrder(root.rightChild, values);
    }

    // Method to find the nth largest node in bst
    public int nthLargest(Node root, int n) {
        // empty
        if (root == null)
            return -1;

        // construct array list
        ArrayList<Integer> values = new ArrayList<>();
        // populate array list using helper method (descending order)
        putInOrder(root, values);
        // keep track of count
        int count = 1;
        // size
        int index = values.size();
        // traverse array until at the nth largest node
        while (count < n){
            index--;
            count++;
        }
        // return the nth largest node
        return values.get(index);
    }

    // Method to delete a node from a bst
    public Node deleteNode(Node root, int target) {
        // parent node pointer
        Node parent = null;
        // current node pointer
        Node current = root;

        // while not null and we haven't found desired node:
        // compare target, traverse bst
        while (current != null && current.value != target) {
            // update parent
            parent = current;


            // if target less than, go left
            if (target < current.value)
                current = current.leftChild;
            // otherwise go right
            else
                current = current.rightChild;
        }

        // not found
        if (current == null)
            return root;

        // Case 1: target node has no children
        if (current.leftChild == null && current.rightChild == null) {

            // if not a root
            if (current != root) {
                // node on left is one to be deleted
                if (parent.leftChild == current)
                    parent.leftChild = null;
                // otherwise node on right is to be deleted
                else
                    parent.rightChild = null;
            }
            // else the root... delete
            else
                root = null;
        }
        // Case 2: target node has two children
        else if (current.leftChild != null && current.rightChild != null) {
            // get the smallest value that is larger than node to be deleted
            Node successor = getMin(current.rightChild);
            // save value we just found
            int value = successor.value;
            // delete the node so there is not a duplicate
            deleteNode(root, successor.value);
            // delete target node by replacing with new successor
            current.value = value;
        }
        //Case 3: target node only has one child
        else {
            Node child;
            // figure out whether the single child is right or left
            // left
            if (current.leftChild != null)
                child = current.leftChild;
            // right
            else
                child = current.rightChild;

            // if were not at the root
            if (current != root) {
                if (current == parent.leftChild)
                    parent.leftChild = child;
                else {
                    parent.rightChild = child;
                }
            }
            else { // target node is root node
                root = child;
            }
        }
        return root;
    }

    // Breadth first traversal of a bst
    void bfs(Node root) {
        // Find the height of the bst
        int height = getHeight(root);
        // print each level from the top down going (when printing level go from left to right)
        for (int index = 1; index <= height; index ++){
            printLevel(root, index);
        }
    }

    // Helper method to print a given level of bst
    // used in bfs()
    void printLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.println(root.value);
        else if (level > 1) {
            printLevel(root.leftChild, level - 1);
            printLevel(root.rightChild, level-1);
        }
    }

    // Depth first traversal of a bst
    // same result as a preOrder Traversal, so just call preOrder()  :-)
    void dfs (Node root) {
        preOrder(root);
    }

}
