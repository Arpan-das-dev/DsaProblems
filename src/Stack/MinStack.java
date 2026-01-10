package Stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.empty()) minStack.push(val);
        else {
            minStack.push(Math.min(val,minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
       return minStack.peek();
    }
}
