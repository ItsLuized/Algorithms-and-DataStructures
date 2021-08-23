package Queue;

import java.util.Iterator;

/**
 * <p>
 * A linear collection that supports element insertion and removal at both ends.
 * </p>
 * <p>
 * The name deque is short for "double ended queue" and is usually pronounced
 * "deck".
 * </p>
 */
public class Deque<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
	private int size;

	private class Node {
		Item item;
		Node next;
		Node previous;
	}

	// construct an empty deque
	public Deque() {
		first = null;
		last = null;
		size = 0;
	}

	// is the deque empty?
	public boolean isEmpty() {
		return size() == 0;
	}

	// return the number of items on the deque
	public int size() {
		return size;
	}

	// add the item to the front
	public void addFirst(Item item) {
		addNullCheck(item);
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		first.previous = null;

		if (isEmpty())
			last = first;
		else
			oldfirst.previous = first;

		size++;
	}

	// add the item to the back
	public void addLast(Item item) {
		addNullCheck(item);
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.previous = oldlast;
		last.next = null;

		if (isEmpty())
			first = last;
		else
			oldlast.next = last;

		size++;
	}

	// remove and return the item from the front

	public Item removeFirst() {
		removeFromEmptyDequeCheck();
		Item item = first.item;
		first = first.next;
		size--;

		if (isEmpty())
			last = first;
		else
			first.previous = null;
		return item;
	}
	// remove and return the item from the back

	public Item removeLast() {
		removeFromEmptyDequeCheck();
		Item item = last.item;
		last = last.previous;
		size--;

		if (isEmpty())
			first = last;
		else
			last.next = null;
		return item;
	}

	private void addNullCheck(Item item) {
		if (item == null)
			throw new IllegalArgumentException("Can't add null item");
	}

	private void removeFromEmptyDequeCheck() {
		if (isEmpty())
			throw new java.util.NoSuchElementException("Can't remove an element because Deque is empty");
	}

	// return an iterator over items in order from front to back
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			if (!hasNext()) {
				throw new java.util.NoSuchElementException("No more elements in Deque");
			}
			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {
			throw new UnsupportedOperationException("This operation is not supported");
		}
	}

	// unit testing (required)
	public static void main(String[] args) {
		Deque<Integer> deque = new Deque<Integer>();

		System.out.println("IS EMPTY: " + deque.isEmpty());

		for (int i = 0; i < 10; i++) {
			deque.addFirst(i);
			System.out.println("SIZE: " + deque.size());
			System.out.println("IS EMPTY: " + deque.isEmpty());
		}

		System.out.println("Elements 0-9 added. We should have seen 1 to 10 printed");

		for (Integer i : deque) {
			System.out.println(i);
		}

		System.out.println("Finished iterating over the iterator. Elements should appear from 9 to 0.");

		for (int i = 0; i < 10; i++) {
			System.out.println(deque.removeLast());
			System.out.println("IS EMPTY: " + deque.isEmpty());
			System.out.println("Deck size: " + deque.size());
		}

		System.out.println("Elements 0-9 removed. They should appear from 0 to 9.");

		for (int i = 0; i < 10; i++) {
			deque.addLast(i);
			System.out.println("IS EMPTY: " + deque.isEmpty());
			System.out.println("Deck size: " + deque.size());
		}

		System.out.println("Elements 0-9 added.");

		for (Integer i : deque) {
			System.out.println(i);
		}

		System.out.println("Finished iterating over the iterator. Elements should appear from 0 to 9");

		for (int i = 0; i < 10; i++) {
			System.out.println(deque.removeFirst());
			System.out.println("IS EMPTY: " + deque.isEmpty());
			System.out.println("Deck size: " + deque.size());
		}

		System.out.println("Elements 0-9 removed. Elements should appear from 0 to 9");

		/*
		 * Deque<Integer> deque = new Deque<>(); StdOut.println("Deque empty? " +
		 * deque.isEmpty()); // Should return true StdOut.println("Deque size: " +
		 * deque.size()); // Should return 0 deque.addFirst(5); // 5 deque.addLast(7);
		 * // 5 7 deque.addLast(9); // 5 7 9 deque.addFirst(3); // 3 5 7 9 for (int item
		 * : deque) { StdOut.print(item + " - "); } StdOut.println();
		 * deque.removeFirst(); // 5 7 9 deque.addFirst(1); // 1 5 7 9
		 * StdOut.println("Deque size: " + deque.size()); // Should return 4 for (int
		 * item : deque) { StdOut.print(item + " - "); } StdOut.println();
		 * deque.removeLast(); // 1 5 7 StdOut.println("removed 9"); for (int item :
		 * deque) { StdOut.print(item + " - "); } StdOut.println();
		 * StdOut.println("Deque empty? " + deque.isEmpty()); // Should return false //
		 * NOW LETS REMOVE EVERYTHING AND STILL TRY TO REMOVE MORE deque.removeLast();
		 * deque.removeLast(); deque.removeLast(); for (int item : deque) {
		 * StdOut.print(item + " - "); } StdOut.println();
		 * StdOut.println("Deque empty? " + deque.isEmpty()); // Should return true
		 */
	}

}
