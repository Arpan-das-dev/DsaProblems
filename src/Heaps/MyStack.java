package Heaps;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Utility class to implement a stack using a single queue.
 *
 * <p>Design a stack that supports push, pop, top, and empty operations, internally using a Queue
 * data structure. The stack must follow the LIFO (Last‑In‑First‑Out) principle, even though the
 * underlying queue is FIFO.</p>
 *
 * <p>This implementation is typically used to demonstrate how to simulate stack behavior with a queue
 * in interview‑style problems such as “Implement Stack using Queues.”</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 250}</b>.</p>
 *
 * <p><b>Approach (simulate LIFO with FIFO):</b></p>
 * <ul>
 *   >Store elements in a single queue.</li>
 *   >On push(x): enqueue x, then rotate the queue by moving all previous elements (size‑1)
 *       to the back, so the newly pushed element becomes the front (top).</li>
 *   >On pop(): dequeue the front element (the last pushed).</li>
 *   >On top(): return the front element without removing it.</li>
 *   >On empty(): return whether the queue is empty.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b>
 *   <ul>
 *     >push: O(n) due to rotation of the queue.</li>
 *     >pop, top, empty: O(1).</li>
 *   </ul>
 * <b>Space Complexity:</b> O(n) for storing n pushed elements in the queue.</p>
 *
 * @author Arpan Das
 * @since 15/04/2026
 */
public class MyStack {
    private final Queue<Integer> stack;

    /**
     * Constructs an empty stack using a queue.
     *
     * <p>Initially, the backing queue is empty, so the stack is also empty.</p>
     */
    public MyStack() {
        this.stack = new LinkedList<>();
    }

    /**
     * Pushes element x onto the top of the stack.
     *
     * <p>The method enqueues x and then rotates the queue so that the newly added element
     * appears at the front, simulating LIFO behavior. All previously enqueued elements are
     * moved to the back of the queue.</p>
     *
     * @param x the element to push onto the stack
     */
    public void push(int x) {
        stack.offer(x);
        int size = stack.size();
        for (int i = 0; i < size - 1; i++) {
            stack.offer(stack.poll());
        }
    }

    /**
     * Removes and returns the element on top of the stack.
     *
     * <p>If the stack is empty, this implementation returns 0 as a fallback value.
     * In a more strict design, an exception or special return value can be used instead.</p>
     *
     * @return the top element of the stack, or 0 if empty
     */
    public int pop() {
        return stack.isEmpty() ? 0 : stack.poll();
    }

    /**
     * Returns the top element of the stack without removing it.
     *
     * <p>If the stack is empty, this implementation returns 0 as a fallback value.
     * This is mainly for consistency with the pop method.</p>
     *
     * @return the top element of the stack, or 0 if empty
     */
    public int top() {
        return stack.isEmpty() ? 0 : stack.peek();
    }

    /**
     * Checks whether the stack is empty.
     *
     * <p>Returns true if there are no elements in the stack, false otherwise.</p>
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean empty() {
        return stack.isEmpty();
    }
}
