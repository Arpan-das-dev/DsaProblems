package Hashing;

import java.util.LinkedList;
import java.util.List;

/**
 * Utility class to implement a HashSet using separate chaining with buckets.
 *
 * <p>Design a HashSet without using any built-in hash table libraries. The implementation must
 * support the following operations:
 * <ul>
 *   <li>{@code add(key)}: Insert a key into the HashSet.</li>
 *   <li>{@code remove(key)}: Remove a key from the HashSet; if the key does not exist, do nothing.</li>
 *   <li>{@code contains(key)}: Return whether the key exists in the HashSet.</li>
 * </ul>
 * The design uses an array of buckets, where each bucket holds a list of keys that hash to the same index.</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 250}</b>.</p>
 *
 * <p><b>Approach (separate chaining with fixed bucket count):</b></p>
 * <ul>
 *   <li>Choose a fixed number of buckets (BASE_SIZE), typically a prime number to reduce collisions.</li>
 *   <li>Use a simple hash function: {@code index = key % BASE_SIZE}.</li>
 *   <li>Each bucket is implemented as a linked list (via {@code List<Integer>}) to store all keys
 *       that hash to that index.</li>
 *   <li>For {@code add(key)}:
 *     <ul>
 *       <li>Compute the bucket index.</li>
 *       <li>If the key is not already in that bucket, insert it (here, at the front).</li>
 *     </ul>
 *   </li>
 *   <li>For {@code remove(key)}:
 *     <ul>
 *       <li>Compute the bucket index.</li>
 *       <li>Remove the key from the bucket if present.</li>
 *     </ul>
 *   </li>
 *   <li>For {@code contains(key)}:
 *     <ul>
 *       <li>Compute the bucket index.</li>
 *       <li>Check whether the key exists in that bucket.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> Average case O(1) per operation when keys are well-distributed across buckets;
 *   worst case O(n) per operation when all keys collide into the same bucket.<br>
 * <b>Space Complexity:</b> O(n + B), where n is the number of stored keys and B is the number of buckets.</p>
 *
 * @author Arpan Das
 * @since 06/10/2026
 */
public class MyHashSet {

    /**
     * Inner class representing a single bucket in the hash set.
     *
     * <p>Each bucket stores a list of integer keys that hash to the same index.
     * The list is implemented using a {@code LinkedList} for efficient insertions and deletions.</p>
     */
    private static class Bucket {
        private final List<Integer> list;

        /**
         * Constructs an empty bucket backed by a linked list.
         */
        public Bucket() {
            this.list = new LinkedList<>();
        }

        /**
         * Inserts a key into this bucket if it is not already present.
         *
         * @param item the key to insert
         */
        public void insert(int item) {
            int bucketIndex = list.indexOf(item);
            if (bucketIndex == -1) {
                list.addFirst(item);
            }
        }

        /**
         * Removes a key from this bucket if it exists.
         *
         * @param item the key to remove
         */
        public void remove(int item) {
            this.list.remove((Integer) item);
        }

        /**
         * Checks whether a key exists in this bucket.
         *
         * @param val the key to search for
         * @return {@code true} if the key exists, {@code false} otherwise
         */
        public boolean contains(int val) {
            return list.contains(val);
        }
    }

    private final int BASE_SIZE = 769;
    private final Bucket[] buckets;

    /**
     * Constructs an empty hash set with a fixed number of buckets.
     *
     * <p>Each bucket is initialized as an empty list. The number of buckets (BASE_SIZE)
     * is chosen as a prime number to help distribute keys more evenly.</p>
     */
    public MyHashSet() {
        this.buckets = new Bucket[BASE_SIZE];
        for (int i = 0; i < BASE_SIZE; i++) {
            buckets[i] = new Bucket();
        }
    }

    /**
     * Computes the bucket index for a given key using a simple modulo hash function.
     *
     * @param key the key to hash
     * @return the index of the bucket where this key should be stored
     */
    private int getIndex(int key) {
        return key % BASE_SIZE;
    }

    /**
     * Adds a key to the hash set.
     *
     * <p>If the key already exists, it is not inserted again (no duplicates).</p>
     *
     * @param key the key to add
     */
    public void add(int key) {
        buckets[getIndex(key)].insert(key);
    }

    /**
     * Removes a key from the hash set.
     *
     * <p>If the key does not exist, this method does nothing.</p>
     *
     * @param key the key to remove
     */
    public void remove(int key) {
        buckets[getIndex(key)].remove(key);
    }

    /**
     * Checks whether a key exists in the hash set.
     *
     * @param key the key to check
     * @return {@code true} if the key exists, {@code false} otherwise
     */
    public boolean contains(int key) {
        return buckets[getIndex(key)].contains(key);
    }
}