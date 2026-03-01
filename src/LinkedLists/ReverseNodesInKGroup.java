package LinkedLists;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;

        int counter = 0;
        ListNode curr = head;

        while (curr != null && counter < k) {
            curr = curr.next;
            counter++;
        }

        if(counter < k) return head;

        ListNode prev = null;
        curr = head;

        for (int i = 0; i < counter; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        head.next = reverseKGroup(curr,k);
        return prev;
    }
}
