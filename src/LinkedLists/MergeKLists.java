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
        if(lists == null || lists.length == 0) return null;
        PriorityQueue <ListNode> nodePriorityQueue = new PriorityQueue<>((a,b)-> a.val - b.val);
        for(ListNode item : lists) {
            if(item!=null) nodePriorityQueue.offer(item); // adding nodes in the priority queue in sorting order;
        }
        ListNode dummy = new ListNode(0); // instantiating a dummy list node with 0 initial value;
        ListNode temp = dummy; // storing the value in temp variable;

        while (!nodePriorityQueue.isEmpty()) {
            ListNode smallest = nodePriorityQueue.poll(); // get the top value as smallest as per queue config
            temp.next = smallest; // setting the next value of temp as smallest;
            temp = temp.next; //store the top value as smallest in the root
            if(smallest.next != null) nodePriorityQueue.offer(smallest);
        }
        return dummy.next;
    }
    /*
     * [[1,4,5],[1,3,4],[2,6]] input
     * now priority queue will store values like
     * [0] -> 1 [1] -> 1 [2] -> 2
     * as it's a node it will get only root values
     */
}

