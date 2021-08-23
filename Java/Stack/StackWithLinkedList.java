package Stack;

import java.util.Iterator;

public class StackWithLinkedList<Item> implements Iterable<Item> {

	private Node first = null;

	// Inner class
	private class Node {
		Item item;
		Node next;
	}

	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}

	public Item pop() {
		// remove and return the Item most recently added
		Item item = first.item;
		first = first.next;
		return item;
	}

	public boolean isEmpty() {
		// is the stack empty?
		return first == null;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

	}

}