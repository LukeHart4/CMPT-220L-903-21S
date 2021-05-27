package base;

import java.util.ArrayList;

public class BST {
    Node first;

    public BST() {
        this.first = null;
    }

    Node insertNode(Node root, int value) {
        // construct new node
        Node newNode = new Node(value);
        // keep track of the node we're on
        Node current = root;
        // current node's parent
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

    void inOrder (Node root) {
        if (root == null)
            return;

        inOrder(root.leftChild);
        System.out.println(root.value);
        inOrder(root.rightChild);

    }

    void preOrder (Node root) {
        if (root == null)
            return;

        System.out.println(root.value);
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }

    void postOrder (Node root) {
        if (root == null)
            return;

        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.println(root.value);
    }


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


    public int getHeight(Node root) {
        if (root == null)
            return 0;

        int leftHeight = getHeight(root.leftChild);
        int rightHeight = getHeight(root.rightChild);

        if (leftHeight > rightHeight)
            return (leftHeight + 1);
        else
            return (rightHeight + 1);
    }

    public Node getMin(Node root) {
        Node current = root;
        while (current.leftChild != null) {
            current = current.leftChild;
        }
        return current;
    }

    public Node getMax (Node root) {
        Node current = root;
        while (current.rightChild != null) {
            current = current.rightChild;
        }
        return current;
    }


    void putInOrder(Node root, ArrayList<Integer> values) {
        if (root == null)
            return;
        putInOrder(root.leftChild, values);
        values.add(root.value);
        putInOrder(root.rightChild, values);
    }


    public int nthLargest(Node root, int n) {
        if (root == null)
            return -1;
        ArrayList<Integer> values = new ArrayList<>();
        putInOrder(root, values);
        int count = 1;
        int index = values.size();
        while (count < n){
            index--;
            count++;
        }
        return values.get(index);
    }

    public Node deleteNode(Node root, int target) {
        Node parent = null;

        Node current = root;

        // compare target, traverse bst
        while (current != null && current.value != target) {
            parent = current;

            if (target < current.value)
                current = current.leftChild;
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
                if (parent.leftChild == current)
                    parent.leftChild = null;
                else
                    parent.rightChild = null;
            }
            else // tree only has a root
                root = null;
        }
        // Case 2: target node has two children
        else if (current.leftChild != null && current.rightChild != null) {

            Node successor = getMin(current.rightChild);

            int value = successor.value;

            deleteNode(root, successor.value);

            current.value = value;
        }
        //Case 3: target node only has one child
        else {
            Node child;
            if (current.leftChild != null)
                child = current.leftChild;
            else
                child = current.rightChild;

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


    void bfs(Node root) {
        int height = getHeight(root);
        for (int index = 1; index <= height; index ++){
            printLevel(root, index);
        }
    }

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

    void dfs (Node root) {
        preOrder(root);
    }





//    // initial method that calls the recursive insertion method
//    void insertNode (Node root, int newValue) {
//        root = recInsert(root, newValue);
//    }
//
//    Node recInsert(Node root, int newValue) {
//        if (root == null) {
//            root = new Node(newValue);
//            return root;
//        }
//        if (newValue < root.value) {
//            root.leftChild = recInsert(root.leftChild, newValue);
//        }
//        else if (newValue > root.value) {
//            root.rightChild = recInsert(root.rightChild, newValue);
//        }
//        return root;
//    }
}
