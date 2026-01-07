package LinkedLists;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEndBrute(ListNode head, int n) {
        if(head.next ==  null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        int length = 0;

        while (curr!=null) {
            curr = curr.next;
            length++;
        }
        int position = length-n;
        curr = dummy;
        while (position > 0) {
            curr = curr.next;
            position --;
        }

        curr.next = curr.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy; // create a dummy for both slow and first pointer
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next; // put ahead the fast node at the nth position ahead
        }
        while (fast.next!=null) { // we will stop at the end when the fast.next will be null
            slow = slow.next;
            fast = fast.next; // keep updating the values as next
        }
        slow.next = slow.next.next; // changing node pointer
        return dummy.next;
    }
}
