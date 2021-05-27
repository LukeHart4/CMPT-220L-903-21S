package base;

public class Node {
    Node parent;
    Node rightChild;
    Node leftChild;
    int value;

    public Node(int value) {
        this.value = value;
        this.rightChild = null;
        this.leftChild = null;
    }
}
