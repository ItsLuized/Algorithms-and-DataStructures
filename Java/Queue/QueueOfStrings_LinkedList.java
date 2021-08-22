package Queue;

public class QueueOfStrings_LinkedList {
  private Node last = null;
  private Node first = null;

  private class Node {
    String item;
    Node next;
  }

  // Check that there's a first
  public void enqueue(String item) {
    Node oldlast = last;
    last = new Node();
    last.item = item;
    last.next = null;
    if (isEmpty())
      first = last;
    else
      oldlast.next = last;
  }

  public String dequeue() {
    String item = first.item;
    first = first.next;
    if (isEmpty())
      last = null;
    return item;
  }

  public boolean isEmpty() {
    return first == null;
  }
}
