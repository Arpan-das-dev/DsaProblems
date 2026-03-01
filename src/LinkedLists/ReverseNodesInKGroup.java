package LinkedLists;

/**
 * Utility class to reverse every k consecutive nodes in linked list.
 *
 * <p>Given head of linked list and integer k, reverse nodes in groups of size k.
 * If remaining nodes < k, leave unchanged. Return head of modified list.</p>
 *
 * <p><b>Approach:</b> Recursive Group Reversal</p>
 * <ul>
 *   <li>Check if current group has k nodes (count forward)</li>
 *   <li>If < k: return original head (no reversal)</li>
 *   <li>Reverse current k nodes using 3-pointer technique</li>
 *   <li>Recurse on remaining list, attach as new head.next</li>
 *   <li>Return new head of reversed group</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n), process each node once.<br>
 * <b>Space Complexity:</b> O(n/k) recursion depth.</p>
 *
 * @author Arpan Das
 * @since 01/03/2026
 */
public class ReverseNodesInKGroup {

    /**
     * Reverses nodes in groups of k in linked list.
     *
     * <p>Recursive reversal: reverse current k, recurse on rest.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: head = [1,2,3,4,5], k = 2
     *        1→2→3→4→5
     * Output: [2,1,4,3,5]
     *         2→1→4→3→5 ✓
     *
     * Input: head = [1,2,3,4,5], k = 3
     * Output: [3,2,1,4,5]
     *
     * Input: head = [1,2,3,4,5], k = 1
     * Output: [1,2,3,4,5] (no change)
     *
     * Input: head = [1], k = 1
     * Output: [1]
     * </pre>
     *
     * @param head head of linked list
     * @param k    group size
     * @return head of modified list
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;

        // Count nodes in current group
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // Less than k nodes: no reversal
        if (count < k) return head;

        // Reverse current k nodes
        ListNode prev = null;
        curr = head;
        for (int i = 0; i < k; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // Recurse on remaining list, attach to reversed group's head
        head.next = reverseKGroup(curr, k);
        return prev;  // New head of reversed group
    }
}