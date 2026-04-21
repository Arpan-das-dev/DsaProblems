package TwoPointers;

/**
 * Utility class to remove all occurrences of a value from an array in‑place.
 *
 * <p>Given an integer array nums and an integer val, remove all instances of val in‑place
 * such that the first k elements of nums contain only elements that are not equal to val.
 * The order of the remaining elements does not matter. The function returns the new length k,
 * and the caller should only consider the first k elements of nums.</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 250}</b>.</p>
 *
 * <p><b>Approach (two‑pointer / write‑index):</b></p>
 * <ul>
 *   <li>Use a single index i to track the next position to write a valid element.</li>
 *   <li>Use a second index j to iterate through the array.</li>
 *   <li>For each element nums[j]:
 *     <ul>
 *       <li>If nums[j] ≠ val, copy it to nums[i] and increment i.</li>
 *       <li>Otherwise, skip this element (do nothing).</li>
 *     </ul>
 *   </li>
 *   <li>At the end, i equals the count of elements not equal to val,
 *       so return i.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n) where n = nums.length; each element is visited once.<br>
 * <b>Space Complexity:</b> O(1); no extra space beyond the input array.</p>
 *
 * @author Arpan Das
 * @since 21/04/2026
 */
public class RemoveElement {

    /**
     * Removes all occurrences of val from nums in‑place and returns the new length.
     *
     * <p>After the call, the first k elements of nums are guaranteed to not contain val.
     * Elements beyond index k − 1 may still contain val, but the caller is not required to consider them.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: nums = [3,2,2,3], val = 3
     * Output: 2, nums = [2,2]
     * Explanation: Two elements ≠ 3 remain; first 2 elements are [2,2].
     *
     * Input: nums = [0,1,2,2,3,0,4,2], val = 2
     * Output: 5, nums = [0,1,3,0,4]
     * Explanation: Five elements ≠ 2 remain; first 5 elements are [0,1,3,0,4].
     * </pre>
     *
     * @param nums input array; must not be null
     * @param val the value to remove
     * @return the new length of the array after removing all occurrences of val
     */
    public int removeElement(int[] nums, int val) {
        int i = 0; // write index for valid elements

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i; // i = number of elements not equal to val
    }
}
