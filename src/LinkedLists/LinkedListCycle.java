package LinkedLists;

/**
 * Utility class to detect if a linked list contains a cycle.
 *
 * <p>Given the head of a linked list, return true if there is a cycle, or false if there is no cycle.
 * A cycle exists if there is some node in the list such that following next pointers eventually
 * returns to the same node.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use Floyd's Tortoise and Hare (two-pointer) algorithm.</li>
 *   <li><b>Slow pointer:</b> moves 1 node per iteration (tortoise).</li>
 *   <li><b>Fast pointer:</b> moves 2 nodes per iteration (hare).</li>
 *   <li>If there is a cycle, the fast pointer will eventually catch up to the slow pointer inside the cycle.</li>
 *   <li>If there is no cycle, the fast pointer will reach the end (null).</li>
 * </ul>
 *
 * <p>The mathematical proof guarantees that if a cycle exists, the pointers will meet regardless
 * of the cycle's starting position or length.</p>
 *
 * <p><b>Time Complexity:</b> O(n), where n is the number of nodes.<br>
 * <b>Space Complexity:</b> O(1), only two pointers used.</p>
 *
 * @author Arpan Das
 * @since 26/01/2026
 */
public class LinkedListCycle {

    /**
     * Detects if a linked list contains a cycle using Floyd's Tortoise and Hare algorithm.
     *
     * <p>Two pointers start at the head: slow moves 1 step, fast moves 2 steps. If they meet,
     * a cycle exists. If fast reaches the end (null), no cycle exists.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: head = [3,2,0,-4], pos = 1 (node with value 2 connects back to itself)
     * Output: true
     * Explanation: fast catches slow at some point in the cycle.
     *
     * Input: head = [1,2], pos = 0 (first node connects back to itself)
     * Output: true
     * Explanation: Cycle starts immediately.
     *
     * Input: head = [1], pos = -1 (no cycle)
     * Output: false
     * Explanation: fast reaches null.
     * </pre>
     *
     * @param head the head of the linked list (may contain a cycle)
     * @return true if the linked list has a cycle, false otherwise
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;  // Moves 2 steps at a time
        ListNode slow = head;  // Moves 1 step at a time

        // Continue while fast pointer can move 2 steps
        while (fast != null && fast.next != null) {
            fast = fast.next.next;  // Fast moves 2 steps
            slow = slow.next;       // Slow moves 1 step

            // If they meet, there is a cycle
            if (fast == slow) return true;
        }

        // Fast reached end → no cycle
        return false;
    }
}

