package base;

public class Main {

    public static void main(String[] args) {
        Node one = new Node("Falco");
        Node two = new Node("Piranha Plant");
        Node three = new Node("King K. Rool");
        Node four = new Node("Lucina");

        FakeList list = new FakeList(one);

        list.addNode(two);
        list.addNode(three);
        list.addNode(four);

        System.out.println("\nDisplaying Original List:\n");
        list.displayList();

        list.removeNode(four);

        System.out.println("\nDisplaying Modified List:\n");
        list.displayList();
    }
}
