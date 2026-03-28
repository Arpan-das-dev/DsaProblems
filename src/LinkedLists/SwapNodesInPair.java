package LinkedLists;

/**
 * Utility class to swap adjacent nodes in linked list by pairs.
 *
 * <p>LeetCode 24: Given {@code head}, swap every two adjacent nodes, return new head. Pairs swapped,
 * odd nodes unchanged. O(1) space iterative solution.</p>
 *
 * <p><b>Approach:</b> Local Pointer Manipulation + Dummy Node</p>
 * <ul>
 *   <li>Dummy node simplifies head handling</li>
 *   <li>While ≥2 nodes: swap curr ↔ curr.next</li>
 *   <li>Update pointers: dummy → second → curr → nextPair</li>
 * </ul>
 *
 * <p>{@code @code Time: O(n), Space: O(1)}<p>
 *
 * @author Arpan Das
 * @since 28/03/2026
 */

public class SwapNodesInPair {

    /**
     * Swaps nodes in pairs iteratively.
     *
     * <p>Dummy node + 3-pointer technique (curr, second, nextPair).</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: 1→2→3→4
     * Swap:   ↕     ↕
     * Output: 2→1→4→3 ✓
     *
     * Input: 1→2→3
     * Output: 2→1→3
     *
     * Input: []
     * Output: []
     * </pre>
     *
     * @param head head of singly linked list
     * @return head of modified list
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prevTail = dummy;

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            // Nodes to swap
            ListNode first = curr;
            ListNode second = curr.next;
            ListNode nextPair = second.next;

            // Swap: prevTail → second → first → nextPair
            second.next = first;
            first.next = nextPair;
            prevTail.next = second;

            // Advance pointers
            prevTail = first;
            curr = nextPair;
        }

        return dummy.next;
    }
}