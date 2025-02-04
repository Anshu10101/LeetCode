import java.util.Stack;

public class MyQueue {
  private Stack<Integer> first;
  private Stack<Integer> second;

  public MyQueue() {
    first = new Stack<>();
    second = new Stack<>();
  }

  public void push(int item) {
    first.push(item);
  }

  public int pop() {
    if (second.isEmpty()) {
      while (!first.isEmpty()) {
        second.push(first.pop());
      }
    }
    if (second.isEmpty()) {
      throw new RuntimeException("Queue is empty");
    }
    return second.pop();
  }

  public int peek() {
    if (second.isEmpty()) {
      while (!first.isEmpty()) {
        second.push(first.pop());
      }
    }
    if (second.isEmpty()) {
      throw new RuntimeException("Queue is empty");
    }
    return second.peek();
  }

  public boolean empty() {
    return first.isEmpty() && second.isEmpty();
  }
}
