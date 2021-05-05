package base;

public class FakeList {
    Node head;
    Node tail;

    // Constructor
    public FakeList (Node node) {
        this.head = node;
        this.tail = node;
    }

    // Add Method
    // Adds new node ot the end
    public void addNode(Node newNode) {
        this.tail.next = newNode;
        this.tail = newNode;
    }

    // Remove Method
    // Removes desired node by linking around it
    public Node removeNode(Node desiredNode) {
        // if head, remove and reassign
        if (desiredNode.value == this.head.value) {
            Node temp = this.head;
            this.head = this.head.next;
            return temp;
        }

        Node current = this.head.next;
        Node previous = this.head;
        boolean found = false;

        while (current != null && !found) {
            if (current.value == desiredNode.value) {
                found = true;
            }
            else {
                previous = current;
                current = current.next;
            }
        }

        if (found) {
            if (current.next == null) { // if tail, remove and reassign
                this.tail = previous;
            }
            previous.next = current.next;
            return current;
        }
        else {
            System.out.println("Node not found!");
            return null;
        }
    }

    // Displays list in the order that they were added
    public void displayList() {
        for (Node current = this.head; current != null; current = current.next) {
            System.out.println(current.value);
        }
    }

}
