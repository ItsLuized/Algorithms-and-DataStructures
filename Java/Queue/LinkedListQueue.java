package Queue;

import java.util.Iterator;

public class LinkedListQueue<T> implements Iterable<T> {

	private Node first;
	private Node last;
	private int size;

	// Create empty Queue.
	public LinkedListQueue() {
		first = null;
		last = null;
		size = 0;
	}

	private class Node {
		T item;
		Node next;
	}

	// Put at end of list.
	// Check if theres at least one existing Node.
	public void enqueue(T item) {
		addNullCheck(item);
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;

		if (isEmpty())
			first = last;
		else
			oldLast.next = last;

		size++;
	}

	// Return the item at the beginning of the list.
	public T dequeue() {
		removeFromEmptyQuequeCheck();
		T item = first.item;
		first = first.next;
		size--;

		if (isEmpty())
			last = null;

		return item;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	private int size() {
		return size;
	}

	// Check that the element to be queued up is not null.
	private void addNullCheck(T item) {
		if (item == null)
			throw new IllegalArgumentException("Can't add null item");
	}

	// Check that the queue is not empty before removing.
	private void removeFromEmptyQuequeCheck() {
		if (isEmpty())
			throw new java.util.NoSuchElementException("Can't remove an element because Queque is empty");
	}

	public Iterator<T> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<T> {

		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public T next() {
			if (!hasNext()) {
				throw new java.util.NoSuchElementException("No more elements in Queue.");
			}
			T item = current.item;
			current = current.next;
			return item;
		}

	}
}