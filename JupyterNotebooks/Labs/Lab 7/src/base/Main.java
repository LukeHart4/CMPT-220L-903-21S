package base;

public class Main {

    public static void main(String[] args) {
        Node one = new Node("Falco");
        Node two = new Node("Piranha Plant");
        Node three = new Node("King K. Rool");
        Node four = new Node("Lucina");
        Node five = new Node("Fox");

        FakeList list = new FakeList();

        list.addNode(one);
        list.addNode(two);
        list.addNode(three);
        list.addNode(four);

        System.out.println("\nDisplaying Original List:\n");
        list.displayList();

        list.removeNode(four);
        list.addNode(five);

        System.out.println("\nDisplaying Modified List:\n");
        list.displayList();
    }
}
