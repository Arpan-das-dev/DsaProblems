package Stack;

import java.util.Stack;
/**
 * Utility class that implements a stack supporting constant-time retrieval
 * of the minimum element alongside standard stack operations.
 *
 * <p>The stack supports the following operations in O(1) time per call:
 * push, pop, top, and getMin.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Maintain two stacks:
 *     <ul>
 *       <li>a primary stack to store all pushed values</li>
 *       <li>a secondary stack to track the current minimum at each level</li>
 *     </ul>
 *   </li>
 *   <li>On each push, push the value onto the main stack and the new minimum
 *       (min of current value and previous minimum) onto the min stack.</li>
 *   <li>On pop, remove the top elements from both stacks to keep them in sync.</li>
 *   <li>The top of the min stack always holds the minimum value of the current stack.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(1) per operation (push, pop, top, getMin).<br>
 * <b>Space Complexity:</b> O(n) for storing values and their corresponding minimums.</p>
 *
 * @author Arpan Das
 * @since 10/01/2026
 */
public class MinStack {
    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    /**
     * Initializes the MinStack with two internal stacks:
     * one for values and one for tracking minimums.
     */
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    /**
     * Pushes the given value onto the stack and updates the current minimum.
     *
     * <p>The value is pushed to the main stack, and the min stack stores
     * the minimum between the new value and the previous minimum.</p>
     *
     * @param val the value to be pushed onto the stack
     */
    public void push(int val) {
        stack.push(val);
        if (minStack.empty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    /**
     * Removes the element on the top of the stack.
     *
     * <p>Both the main stack and the min stack are popped to keep
     * their states consistent.</p>
     */
    public void pop() {
        stack.pop();
        minStack.pop();
    }

    /**
     * Retrieves the top element of the stack without removing it.
     *
     * @return the top element of the stack
     */
    public int top() {
        return stack.peek();
    }

    /**
     * Retrieves the minimum element currently in the stack in O(1) time.
     *
     * @return the current minimum element
     */
    public int getMin() {
        return minStack.peek();
    }
}