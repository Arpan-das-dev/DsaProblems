package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class implementing time-based key-value store {@code NeetCode 150}.
 *
 * <p>LeetCode 981: Design TimeMap supporting set(key,value,timestamp) and get(key,timestamp) →
 * value with the largest timestamp ≤ given timestamp (or "" if none).</p>
 *
 * <p><b>Approach:</b> HashMap<String, List<Pair>> + Binary Search</p>
 * <ul>
 *   <li>Store timestamp-sorted pairs per key</li>
 *   <li>Binary search the largest timestamp ≤ target</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> Set=O(1), Get=O(log t) (t timestamps).<br>
 * <b>Space Complexity:</b> O(total pairs).</p>
 *
 * @author Arpan Das
 * @since 21/03/2026
 */

public class TimeMap {

    private final Map<String, List<Pair>> timeMap;

    /** Initialize data structure. */
    public TimeMap() {
        this.timeMap = new HashMap<>();
    }

    /**
     * Store key-value pair at given timestamp (timestamps strictly increasing).
     */
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>())
                .add(new Pair(timestamp, value));
    }

    /**
     * Returns value for key with largest timestamp ≤ stamp.
     *
     * <p>Binary search on sorted timestamps per key.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * set("foo","bar",1)
     * get("foo",1) → "bar"
     * get("foo",3) → "bar"
     *
     * set("foo","bar2",4)
     * get("foo",4) → "bar2"
     * get("foo",5) → "bar2"
     * </pre>
     *
     * @param key key to query
     * @param timestamp max timestamp
     * @return value or "" if none
     */
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }

        List<Pair> pairs = timeMap.get(key);
        String result = "";
        int left = 0, right = pairs.size() - 1;

        // Binary search: find rightmost timestamp ≤ target
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (pairs.get(mid).timestamp <= timestamp) {
                result = pairs.get(mid).value;
                left = mid + 1;  // Try larger timestamp
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    /** Timestamp-value pair (chronologically stored). */
    static class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
