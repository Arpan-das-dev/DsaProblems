package LinkedLists;

public class CopyListWithRandomPointers {
    private static class Node{
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        // edge case check
        if(head == null) return null;

        // step 1 -> assign new node next to original one
        Node curr = head;
        while (curr != null){
            Node node = new Node(curr.val);
            node.next = curr.next;
            curr.next = node;
            curr = node.next;
        }

        // step 2 -> assign random pointer for each new node created
        curr = head;
        while (curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // step -> 3 create a copy from the head
        Node result = new Node(-1);
        Node dummy = result;
        curr = head;

        while (curr != null){
            dummy.next = curr.next;
            curr.next = curr.next.next;

            dummy = dummy.next;
            curr = curr.next;
        }
        return result.next;
    }
}
