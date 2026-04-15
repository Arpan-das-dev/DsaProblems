package Heaps;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private final Queue<Integer> stack;

    public MyStack() {
        this.stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.offer(x);
        int size = stack.size();
        for (int i = 0; i < size-1; i++) {
            stack.offer(stack.poll());
        }
    }

    public int pop() {
        return stack.isEmpty() ? 0: stack.poll();
    }

    public int top() {
        return stack.isEmpty() ? 0:stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
