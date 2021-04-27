package base;

public class Main {

    public static void main(String[] args) {
	    Node one = new Node("Falco");
	    Node two = new Node("Piranha Plant");
	    Node three = new Node("King K. Rool");
	    Node four = new Node("Lucina");

	    one.next = two;
	    two.next = three;
	    three.next = four;

	    for (Node current = one; current != null; current = current.next) {
	    	System.out.println(current.value);
		}
    }
}
