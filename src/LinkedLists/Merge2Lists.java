package LinkedLists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Utility class to merge two sorted linked lists into one sorted linked list.
 *
 * <p>Given the heads of two sorted linked lists {@code list1} and {@code list2}, merge them
 * into one sorted list. The function should return the head of the merged list.</p>
 *
 * <p><b>Approaches:</b></p>
 * <ul>
 *   <li><b>Overkill (Priority Queue):</b> Uses a min-heap to always extract the smallest node,
 *       then adds the next node from the same list. Correct but inefficient.</li>
 *   <li><b>Optimal (Two Pointers):</b> Compare the current heads of both lists, pick the smaller one,
 *       advance that pointer, and link the nodes iteratively until both lists are exhausted.</li>
 * </ul>
 *
 * <p>The optimal approach is linear time and space, as it traverses each list exactly once.</p>
 *
 * <p><b>Time Complexity:</b> O(n + m) for optimal, O((n+m)log(n+m)) for priority queue,
 * where n and m are list lengths.<br>
 * <b>Space Complexity:</b> O(1) for optimal, O(n+m) for priority queue.</p>
 *
 * @author Arpan Das
 * @since 28/01/2026
 */
public class Merge2Lists {

    /**
     * Overkill solution using Priority Queue (min-heap) to merge two sorted lists.
     *
     * <p>Adds the head nodes to a min-heap, extracts the smallest, links it, and adds
     * the next node from the same list. Repeats until both lists are exhausted.</p>
     *
     * @param list1 first sorted linked list
     * @param list2 second sorted linked list
     * @return head of the merged sorted linked list
     */
    public ListNode mergeTwoListsOverKill(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Min-heap ordered by node value
        PriorityQueue<ListNode> nodePriorityQueue = new PriorityQueue<>(
                Comparator.comparingInt(a -> a.val)
        );
        nodePriorityQueue.offer(list1);
        nodePriorityQueue.offer(list2);

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (!nodePriorityQueue.isEmpty()) {
            ListNode smallest = nodePriorityQueue.poll();
            temp.next = smallest;
            temp = temp.next;

            // Add next node from the same list
            if (smallest.next != null) {
                nodePriorityQueue.offer(smallest.next);
            }
        }
        return dummy.next;
    }

    /**
     * Optimal two-pointer iterative solution to merge two sorted linked lists.
     *
     * <p>Uses a dummy node and current pointer. Compares heads of both lists, links the smaller node,
     * advances that list's pointer, and continues until both lists are exhausted. Appends any remaining nodes.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input:  list1 = [1,2,4], list2 = [1,3,4]
     * Output: [1,1,2,3,4,4]
     * Explanation: Nodes merged in sorted order.
     *
     * Input:  list1 = [], list2 = []
     * Output: []
     *
     * Input:  list1 = [], list2 = [0]
     * Output: [0]
     *
     * Input:  list1 = [1,2,4], list2 = []
     * Output: [1,2,4]
     * </pre>
     *
     * @param p first sorted linked list head
     * @param q second sorted linked list head
     * @return head of the merged sorted linked list
     */
    public ListNode mergeTwoLists(ListNode p, ListNode q) {
        if (p == null) return q;
        if (q == null) return p;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        // Compare and merge while both lists have nodes
        while (p != null && q != null) {
            if (p.val > q.val) {
                curr.next = q;
                q = q.next;
            } else {
                curr.next = p;
                p = p.next;
            }
            curr = curr.next;
        }

        // Append remaining nodes from whichever list is not exhausted
        curr.next = (p == null) ? q : p;
        return dummy.next;
    }
}