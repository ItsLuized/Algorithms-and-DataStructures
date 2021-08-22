package Stack;

public class Exercise {
  public static void main(String[] args) {
    int n = 50;

    StackWithLinkedList<Integer> stack = new StackWithLinkedList<Integer>();
    while (n > 0) {
      stack.push(n % 2);
      n = n / 2;
    }

    for (int digit : stack) {
      System.out.print(digit);
    }

    System.out.println();
  }

}
