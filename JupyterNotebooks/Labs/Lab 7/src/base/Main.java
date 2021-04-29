package base;

public class Main {

    public static void main(String[] args) {
        Node one = new Node("Falco");
        Node two = new Node("Piranha Plant");
        Node three = new Node("King K. Rool");
        Node four = new Node("Lucina");

        // one.next = two;
        addNode(one, two);
        // two.next = three;
        addNode(two, three);
        // three.next = four;
        addNode(three, four);

        printList(one);

    }

    public static void printList(Node start) {
        for (Node current = start; current != null; current = current.next) {
            System.out.println(current.value);
        }
    }

    public static void addNode(Node previous, Node newNode) {
        previous.next = newNode;
    }

    public static void remove(Node node) {

    }
}
