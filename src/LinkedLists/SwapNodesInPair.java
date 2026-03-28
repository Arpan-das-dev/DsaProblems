package LinkedLists;

public class SwapNodesInPair {
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        ListNode result = new ListNode(0,head);
        ListNode dummy = result;

        while (curr != null && curr.next != null){
            ListNode npn = curr.next.next;
            ListNode second = curr.next;

            second.next = curr;
            curr.next = npn;
            dummy.next = second;

            dummy = curr;
            curr = npn;
        }
        return result.next;
    }
}