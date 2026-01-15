package LinkedLists;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode prev = null;
        ListNode current = head;
        while(current!= null) {
           ListNode temp = current.next; // get the next value
           current.next = prev; // set the next value as previous
           prev = current; // reverse the current
           current = temp; // assign the value as next node
        }
        return prev;
    }
}
