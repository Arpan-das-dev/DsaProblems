package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class to find the Next Greater Element (NGE) for each element of nums1 in nums2.
 *
 * <p>Given two arrays nums1 and nums2 where nums1 is a subset of nums2, return an array
 * result such that result[i] is the next greater element of nums1[i] in nums2.
 * The next greater element is the first element to the right which is greater than nums1[i];
 * if no such element exists, the result is -1.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use a monotonic stack (decreasing order) on nums2 to find the next greater element for each element.
 *   <li>For each element in nums2:
 *     <ul>
 *       <li>While the stack is not empty and the top is less than current element,
 *           set the next greater element of the popped element as the current element.</li>
 *       <li>Push the current element onto the stack.</li>
 *     </ul>
 *   </li>
 *   <li>For each element in nums1, look up its next greater element from the map (or -1 if not found).</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(m + n) where m = nums1.length, n = nums2.length.<br>
 * <b>Space Complexity:</b> O(n) for the stack and map.</p>
 *
 * @author Arpan Das
 * @since 20/01/2026
 */
public class NextGreaterElement {
    /**
     * Returns the next greater element for each element of nums1 as it appears in nums2.
     *
     * <p>For each x in nums1, the result[i] is the first element in nums2 that is greater than x
     * and appears to the right of x in nums2. If no such element exists, the result is -1.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
     * Output: [ -1, 3, -1 ]
     * Explanation:
     *   For 4 in nums1: there is no element greater than 4 to its right in nums2 => -1
     *   For 1 in nums1: the next greater element in nums2 is 3 => 3
     *   For 2 in nums1: there is no element greater than 2 to its right in nums2 => -1
     *
     * Input: nums1 = [2,4], nums2 = [1,2,3,4]
     * Output: [3, -1]
     * Explanation:
     *   For 2: the next greater element in nums2 is 3 => 3
     *   For 4: there is no greater element to the right of 4 => -1
     * </pre>
     *
     * @param nums1 array of queries (subset of nums2)
     * @param nums2 array in which the next greater element is to be found
     * @return array of next greater elements for each element in nums1
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store next greater element for each element in nums2
        Map<Integer, Integer> map = new HashMap<>();
        // Stack to maintain a decreasing order of elements
        Deque<Integer> integerDeque = new ArrayDeque<>();

        // Traverse nums2 to build the next greater element map
        for (int item : nums2) {
            // While stack is not empty and top < current item,
            // current item is the next greater element for the top
            while (!integerDeque.isEmpty() && integerDeque.peek() < item) {
                map.put(integerDeque.pop(), item);
            }
            // Push current item onto the stack
            integerDeque.push(item);
        }

        // For each element in nums1, look up its next greater element
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}
