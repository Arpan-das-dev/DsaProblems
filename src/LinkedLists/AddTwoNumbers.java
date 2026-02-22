package LinkedLists;

/**
 * Utility class to add two non-negative integers represented as reversed linked lists.
 *
 * <p>Given two non-empty linked lists representing non-negative integers (digits stored in reverse
 * order), return sum as linked list. Each node contains single digit (0-9). Lists don't have leading
 * zeros except number 0 itself.</p>
 *
 * <p><b>Approach:</b> Digit-by-Digit Addition with Carry + Dummy Node</p>
 * <ul>
 *   <li>Traverse both lists simultaneously, add digits + carry</li>
 *   <li>New digit = {@code sum % 10}, carry = {@code sum / 10}</li>
 *   <li>Handle unequal lengths and final carry</li>
 *   <li>Dummy node simplifies head management</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(max(m,n)).<br>
 * <b>Space Complexity:</b> O(max(m,n)) for result list.</p>
 *
 * @author Arpan Das
 * @since 22/02/2026
 */

public class AddTwoNumbers {

    /**
     * Adds two numbers represented as reversed linked lists.
     *
     * <p>Simulates column-wise addition from right (ones place), propagates carry leftward.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: l1 = [2,4,3] (342), l2 = [5,6,4] (465)
     *        2→4→3
     *        5→6→4
     * Output: [7,0,8] (807)
     *        7→0→8
     * Explanation: 342 + 465 = 807
     *
     * Input: l1 = [0] (0), l2 = [0] (0)
     * Output: [0]
     *
     * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     *        9999999 + 9999 = 10009998
     * Output: [8,9,9,9,0,0,0,1]
     * </pre>
     *
     * @param l1 first number (reversed digits)
     * @param l2 second number (reversed digits)
     * @return sum as linked list (reversed digits)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);  // Dummy simplifies head
        ListNode curr = dummy;
        int carry = 0;

        // Process until both lists exhausted + no carry
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            // Add digit from l1 if available
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add digit from l2 if available
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Create new digit node
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        return dummy.next;  // Skip dummy head
    }
}