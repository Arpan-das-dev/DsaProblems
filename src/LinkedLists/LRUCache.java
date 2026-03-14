package LinkedLists;

import java.util.HashMap;
import java.util.Map;

/**
 * Thread-safe LRU (Least Recently Used) Cache implementation using HashMap and doubly linked list.
 *
 * <p>Implements a fixed-capacity cache that evicts the least recently used items when capacity is reached.
 * Supports O(1) get and put operations through HashMap for key-node mapping and doubly linked list
 * for maintaining access order (head = most recent, tail = least recent).</p>
 *
 * <p><b>Key Features:</b></p>
 * <ul>
 *   <li><b>Doubly Linked List:</b> Maintains MRU (head) to LRU (tail) order. Nodes move to head on access.</li>
 *   <li><b>HashMap:</b> Provides O(1) key-to-node lookup for fast retrieval and updates.</li>
 *   <li><b>Capacity Management:</b> Automatically removes tail node (LRU) when adding beyond capacity.</li>
 * </ul>
 *
 * <p><b>Operations:</b></p>
 * <ul>
 *   <li><code>get(key)</code>: Returns value if exists, moves node to head (MRU), else -1.</li>
 *   <li><code>put(key, value)</code>: Updates existing or adds new entry, moves to head, evicts LRU if full.</li>
 * </ul>
 *
 * <p><b>Examples:</b></p>
 * <pre>
 * LRUCache cache = new LRUCache(2); // capacity 2
 * cache.put(1, 1); // cache is {1=1}
 * cache.put(2, 2); // cache is {1=1, 2=2}
 * cache.get(1);    // returns 1, cache is {2=2, 1=1}
 * cache.put(3, 3); // LRU key 2 evicted, cache is {1=1, 3=3}
 * cache.get(2);    // returns -1 (not found)
 * cache.put(4, 4); // LRU key 1 evicted, cache is {4=4, 3=3}
 * cache.get(1);    // returns -1 (not found)
 * cache.get(3);    // returns 3, cache is {4=4, 3=3}
 * cache.get(4);    // returns 4, cache is {3=3, 4=4}
 * </pre>
 *
 * <p><b>Time Complexity:</b> O(1) for both get and put operations.<br>
 * <b>Space Complexity:</b> O(capacity) for HashMap and linked list nodes.</p>
 *
 * @author Arpan Das
 * @since 14/03/2026
 */
public class LRUCache {

    /**
     * Internal doubly linked list node storing key-value pair and prev/next pointers.
     */
    private static class Node {
        Node prev;
        Node next;
        int key;
        int value;

        /**
         * Constructs a new node with given key and value.
         *
         * @param key   the cache key
         * @param value the cache value
         */
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> keyMap;
    private final Node head;  // Sentinel: most recently used (MRU) end
    private final Node tail;  // Sentinel: least recently used (LRU) end

    /**
     * Constructs an LRUCache with specified capacity.
     *
     * <p>Initializes HashMap for O(1) lookups and doubly linked list with sentinel head/tail nodes.
     * Links head → tail initially (empty list state).</p>
     *
     * @param capacity maximum number of key-value pairs cache can hold
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyMap = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);

        // Initialize empty doubly linked list: head ↔ tail
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Retrieves value for given key, or -1 if key doesn't exist.
     *
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Check if key exists in HashMap</li>
     *   <li>If not found, return -1</li>
     *   <li>Remove node from current position in linked list</li>
     *   <li>Insert node immediately after head (MRU position)</li>
     *   <li>Return node value</li>
     * </ol>
     *
     * @param key the key to retrieve
     * @return value associated with key, or -1 if key not found
     */
    public int get(int key) {
        if (!keyMap.containsKey(key)) {
            return -1;
        }
        Node node = keyMap.get(key);
        removeNode(node);
        insertAfterHead(node);
        return node.value;
    }

    /**
     * Inserts or updates key-value pair in cache.
     *
     * <p><b>Algorithm for Update (key exists):</b></p>
     * <ol>
     *   <li>Update node value</li>
     *   <li>Remove from current position</li>
     *   <li>Insert after head (MRU)</li>
     * </ol>
     *
     * <p><b>Algorithm for Insert (new key):</b></p>
     * <ol>
     *   <li>If at capacity: remove tail.prev (LRU) from HashMap and list</li>
     *   <li>Create new node</li>
     *   <li>Add to HashMap</li>
     *   <li>Insert after head (MRU)</li>
     * </ol>
     *
     * @param key   the key to insert/update
     * @param value the value to associate with key
     */
    public void put(int key, int value) {
        if (keyMap.containsKey(key)) {
            // Update existing key
            Node node = keyMap.get(key);
            node.value = value;
            removeNode(node);
            insertAfterHead(node);
        } else {
            // New key - check capacity
            if (keyMap.size() == capacity) {
                // Evict LRU (node before tail)
                keyMap.remove(tail.prev.key);
                removeNode(tail.prev);
            }
            Node node = new Node(key, value);
            keyMap.put(key, node);
            insertAfterHead(node);
        }
    }

    /**
     * Inserts node immediately after head sentinel (MRU position).
     *
     * <p>Updates doubly linked list pointers to maintain: head → node → old head.next</p>
     *
     * @param node node to insert after head
     */
    private void insertAfterHead(Node node) {
        // Link with current head.next
        head.next.prev = node;
        node.next = head.next;
        // Link with head
        head.next = node;
        node.prev = head;
    }

    /**
     * Removes specified node from doubly linked list.
     *
     * <p>Updates adjacent nodes' pointers: node.prev ↔ node.next</p>
     *
     * @param node node to remove from list
     */
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
