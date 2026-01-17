package LinkedLists;

public class ReOrderList {
//Input: head = [1,2,3,4,5]
//Output: [1,5,2,4,3]
public void reorderList(ListNode head) {
    if (head == null || head.next == null) return;

    // 1. Find middle
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // 2. Reverse second half
    ListNode prev = null, curr = slow.next;
    slow.next = null; // split the list

    while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    // 3. Merge two halves
    ListNode first = head, second = prev;
    while (second != null) {
        ListNode t1 = first.next;
        ListNode t2 = second.next;

        first.next = second;
        second.next = t1;

        first = t1;
        second = t2;
    }
}
}
