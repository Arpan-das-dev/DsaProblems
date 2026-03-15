package LinkedLists;

/**
 * In-place O(1) space solution for deep copying linked list with random pointers.
 *
 * <p>Given a linked list where each node contains a value, next pointer, and random pointer
 * (which can point to any node or null), create a deep copy of the list preserving all connections.</p>
 *
 * <p><b>Key Insight:</b> 3-step in-place algorithm interleaving original and copy nodes:
 * <ol>
 *   <li>Insert copy nodes between originals: orig → copy → orig_next</li>
 *   <li>Fix copy random pointers using orig.random.next</li>
 *   <li>Separate original and copy lists</li>
 * </ol></p>
 *
 * <p><b>Examples:</b></p>
 * <pre>
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 *
 * Input: head = [[]]
 * Output: [[]]
 * </pre>
 *
 * <p><b>Time Complexity:</b> O(n) single pass per step.<br>
 * <b>Space Complexity:</b> O(1) excluding output (in-place modification).</p>
 *
 * @author Arpan Das
 * @since 15/03/2026
 */
public class CopyListWithRandomPointers {

    /**
     * Node class definition for linked list with random pointers.
     */
    private static class Node {
        int val;
        Node next;
        Node random;

        /**
         * Constructs node with value, null next/random pointers.
         *
         * @param val node value
         */
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * Creates deep copy of linked list with random pointers using 3-step in-place algorithm.
     *
     * <p><b>Step 1 - Interleave:</b> orig → copy → orig_next</p>
     * <pre>Before: 7→13→11    After: 7→7'→13→13'→11→11'</pre>
     *
     * <p><b>Step 2 - Fix Random:</b> copy.random = orig.random.next</p>
     *
     * <p><b>Step 3 - Separate:</b> Extract copy list, restore original</p>
     *
     * @param head head of original list
     * @return head of copied list
     */
    public Node copyRandomList(Node head) {
        // Edge case: empty list
        if (head == null) return null;

        // Step 1: Insert copy nodes between originals (interleave)
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;      // copy → orig_next
            curr.next = copy;           // orig → copy
            curr = copy.next;           // move to orig_next
        }

        // Step 2: Assign random pointers for copy nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;  // copy.random = orig.random's copy
            }
            curr = curr.next.next;  // skip copy node
        }

        // Step 3: Separate copy list and restore original
        Node dummy = new Node(-1);
        Node copyCurr = dummy;
        curr = head;

        while (curr != null) {
            copyCurr.next = curr.next;      // link copy
            curr.next = curr.next.next;     // restore original

            copyCurr = copyCurr.next;
            curr = curr.next;
        }

        return dummy.next;  // head of copy list
    }
}
