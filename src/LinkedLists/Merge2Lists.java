package LinkedLists;


import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge2Lists {
    public ListNode mergeTwoListsOverKill(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        PriorityQueue<ListNode> nodePriorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        nodePriorityQueue.offer(list1);
        nodePriorityQueue.offer(list2);

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (!nodePriorityQueue.isEmpty()){
            ListNode smallest = nodePriorityQueue.poll();
            temp.next = smallest;
            temp =temp.next;
            if(smallest.next != null) nodePriorityQueue.offer(smallest.next);
        }

        return dummy.next;
    }

    public ListNode mergeTwoLists(ListNode p, ListNode q){
        if (p == null) return q;
        if (q == null) return p;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (p != null && q != null){
            if(p.val > q.val) {
                curr.next = q;
                q = q.next;
            } else {
                curr.next = p;
                p = p.next;
            }
            curr = curr.next;
        }
        curr.next = p == null ? q : p;
        return dummy.next;
    }
}
