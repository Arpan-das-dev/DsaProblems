package LinkedLists;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static class Node{
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private final int capacity;
    private final Map<Integer,Node> keyMap;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        keyMap = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!keyMap.containsKey(key)){
            return -1;
        }
        Node node = keyMap.get(key);
        removeNode(node);
        insertAfterHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(keyMap.containsKey(key)){
            Node node = keyMap.get(key);
            node.value = value;
            removeNode(node);
            insertAfterHead(node);
        } else {
            if(keyMap.size() == capacity){
                keyMap.remove(tail.prev.key);
                removeNode(tail.prev);
            }
            Node node = new Node(key,value);
            keyMap.put(key,node);
            insertAfterHead(node);
        }
    }

    private void insertAfterHead(Node node) {
       head.next.prev = node;
       node.next = head.next;

       head.next = node;
       node.prev = head;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
