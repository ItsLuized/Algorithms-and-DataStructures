package Stack;

import java.util.Iterator;

public class StackWithResizingArray<Item> implements Iterable<Item> {

  private Item[] stack;
  private int N;

  public StackWithResizingArray() {
    // Create Empty Stack (Array to represent it)
    stack = (Item[]) new Object[1];
    N = 0;
  }

  public void push(Item item) {
    // Put item to the top of the stack
    if (N == stack.length)
      resize(2 * stack.length);
    stack[N++] = item;
  }

  public Item pop() {
    // remove and return the Item most recently added
    Item item = stack[N--];
    stack[N] = null;
    if (N > 0 && N == stack.length / 4)
      resize(stack.length / 2);
    return item;
  }

  public boolean isEmpty() {
    // is the stack empty?
    return (N == 0);
  }

  public int size() {
    return stack.length;
  }

  private void resize(int capacity) {
    Item[] copy = (Item[]) new Object[capacity];
    for (int i = 0; i < N; i++)
      copy[i] = stack[i];

    stack = copy;
  }

  public static void main(String[] args) {
    StringStackWithResizingArray stack = new StringStackWithResizingArray();
    stack.push("I");
    stack.push("want");
    System.out.println(stack.size()); // 2
    stack.push("to");
    System.out.println(stack.size()); // 4
    stack.push("break");
    stack.push("Free");
    System.out.println(stack.size()); // 8
    // For the array to size down to 4 again, It has to have just 2 elements
    stack.pop();
    stack.pop();
    stack.pop();
    System.out.println(stack.size()); // 4
    // It resized to half, as desired!
  }

  @Override
  public Iterator<Item> iterator() {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<Item> {

    private int i = N;

    @Override
    public boolean hasNext() {
      return i > 0;
    }

    @Override
    public Item next() {
      return stack[--i];
    }

  }

}
