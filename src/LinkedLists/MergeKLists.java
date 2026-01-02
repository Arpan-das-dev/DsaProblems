package LinkedLists;

import java.util.PriorityQueue;

/**
 * Utility class for merging multiple sorted linked lists
 * into a single sorted linked list.
 *
 * <p><b>Problem:</b>
 * Given an array of k sorted linked lists, merge them into
 * one sorted linked list.</p>
 *
 * <p><b>Approach:</b>
 * <ul>
 *   <li>Use a {@link PriorityQueue} (min-heap) to always select
 *       the smallest available node among the lists</li>
 *   <li>Insert the head of each list into the heap</li>
 *   <li>Repeatedly extract the smallest node and attach it to
 *       the result list</li>
 *   <li>If the extracted node has a next node, insert it into the heap</li>
 * </ul>
 *
 * <p>This ensures efficient merging while preserving sorted order.</p>
 *
 * <p><b>Time Complexity:</b> O(N log k),
 * where N is the total number of nodes and k is the number of lists<br>
 * <b>Space Complexity:</b> O(k)</p>
 *
 * @author Arpan Das
 * @since 03/01/2025
 */
public class MergeKLists {

    /**
     * Merges k sorted linked lists into one sorted linked list.
     *
     * @param lists an array of ListNode heads
     * @return the head of the merged sorted linked list
     */
    public ListNode mergeKLists(ListNode[] lists) {

        // Edge case: null or empty input
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Min-heap based on node values
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add head of each list to the heap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        // Dummy node to simplify list construction
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Process nodes in ascending order
        while (!minHeap.isEmpty()) {

            // Extract smallest node
            ListNode smallest = minHeap.poll();

            // Attach to result list
            tail.next = smallest;
            tail = tail.next;

            // Add next node from the same list to heap
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        // Return merged list (skip dummy)
        return dummy.next;
    }

}

