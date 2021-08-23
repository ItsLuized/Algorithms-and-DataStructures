package Stack;

public class StringStackWithLinkedList {

	private Node first = null;

	// Inner class
	private class Node {
		String item;
		Node next;
	}

	public void push(String item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}

	public String pop() {
		// remove and return the string most recently added
		if (isEmpty())
			return "Stack is empty";
		String item = first.item;
		first = first.next;
		return item;
	}

	public boolean isEmpty() {
		// is the stack empty?
		return first == null;
	}

	public static void main(String[] args) {
		StringStackWithLinkedList stack = new StringStackWithLinkedList();
		stack.push("I");
		System.out.println(stack.pop()); // Pop only element
		System.out.println(stack.pop()); // Should return "Stack is empty"
	}
}
