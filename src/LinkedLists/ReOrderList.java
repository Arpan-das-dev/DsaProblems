package LinkedLists;

/**
 * Utility class for rearranging a singly-linked list in-place into the form
 * L₀ → Lₙ → L₁ → Lₙ₋₁ → L₂ → Lₙ₋₂ → ...
 *
 * <p>Given the head of a singly linked list, reorder it such that the first,
 * last, second, second-last, ... nodes are connected in the specified order.
 * </p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li><b>Step 1 – Find middle:</b> Use slow/fast pointer technique to find the middle node.
 *       The list is then conceptually split into two halves: left half and reversed right half.</li>
 *   <li><b>Step 2 – Reverse second half:</b> Reverse the list starting from the node after the middle,
 *       so that the tail part becomes backward and can be merged from the end.</li>
 *   <li><b>Step 3 – Merge:</b> Interleave the first half and the reversed second half:
 *       pick one node from the first half, then one from the reversed second half,
 *       and link them alternately until the second half is exhausted.</li>
 * </ul>
 *
 * <p>This in-place solution reorders the list in O(n) time without extra space for a new list.</p>
 *
 * <p><b>Time Complexity:</b> O(n), where n is the number of nodes.<br>
 * <b>Space Complexity:</b> O(1), as only a few pointers are used.</p>
 *
 * @author Arpan Das
 * @since 17/01/2026
 */
public class ReOrderList {

    /**
     * Reorders the singly-linked list in-place to the pattern:
     * first node → last node → second node → second-last node → ...
     *
     * <p>For example, given list [1,2,3,4,5], reorders to [1,5,2,4,3].<br>
     * Given list [1,2,3,4], reorders to [1,4,2,3].</p>
     *
     * <p>The method does nothing if the list is empty or has only one node.</p>
     *
     * @param head the head of the linked list to reorder
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1. Find the middle node using slow and fast pointers
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Now, slow is at the middle; the second half starts at slow.next

        // 2. Reverse the second half of the list
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null; // Cut the first half from the second half

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // Now, prev is the head of the reversed second half

        // 3. Merge the first half (head) and the reversed second half (prev)
        ListNode first = head;
        ListNode second = prev;
        while (second != null) {
            ListNode t1 = first.next; // Save next node in first half
            ListNode t2 = second.next; // Save next node in second half

            first.next = second; // Link first half’s current node to second half
            second.next = t1; // Link second half’s node to the next node in first half

            first = t1; // Move to the next node in first half
            second = t2; // Move to the next node in second half
        }
    }
}
