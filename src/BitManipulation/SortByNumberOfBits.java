package BitManipulation;

import java.util.Arrays;

/**
 * Utility class to sort array by number of 1-bits, then by value.
 *
 * <p><b>this is not from {@code neetcode 150} sheet</b></p>
 *
 * <p>Given array of integers {@code arr}, sort in ascending order by pop count (number of 1-bits),
 * then by numerical value if pop count equal. Pop count example: 2 (10₂)=1, 4 (100₂)=1, 5 (101₂)=2.</p>
 *
 * <p><b>Approach:</b> Custom Comparator + Wrapper Array</p>
 * <ul>
 *   <li>Convert primitive {@code int[]} to {@code Integer[]} for sorting</li>
 *   <li>Comparator: primary {@code Integer.bitCount(a) - Integer.bitCount(b)}, secondary {@code a-b}</li>
 *   <li>Copy sorted result back to original array</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n log n).<br>
 * <b>Space Complexity:</b> O(n) for wrapper array.</p>
 *
 * @author Arpan Das
 * @since 26/02/2026
 */

public class SortByNumberOfBits {

    /**
     * Sorts array by number of 1-bits (primary), then by value (secondary).
     *
     * <p>Uses stable sort with custom comparator leveraging {@code Integer.bitCount()}.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: arr = [0,1,2,3,4,5,6,7,8]
     *        0(0000)=0, 1(0001)=1, 2(0010)=1, 3(0011)=2, 4(0100)=1
     * Output: [0,1,2,4,8,16,3,5,6,7]
     *         ↑0bits ↑1bit(0,1,2,4,8,16) ↑2bits(3,5,6,7)
     *
     * Input: arr = [1024,4,14,1,5,6]
     * Output: [4,1,5,14,6,1024]
     *         ↑1bit ↑2bits ↑3bits ↑1bit(higher value)
     *
     * Input: arr = [7,4,8,12,1,3]
     * Output: [4,8,1,3,7,12]
     * </pre>
     *
     * @param arr input array of integers
     * @return sorted array (same reference, modified in-place)
     */
    public int[] sortByBits(int[] arr) {
        // Handle edge cases
        if (arr == null || arr.length == 0) return new int[] {};
        if (arr.length == 1) return arr;

        // Convert to Integer[] for custom sorting
        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }

        // Sort by popcount first, then by value
        Arrays.sort(nums, (a, b) -> {
            int popcountDiff = Integer.bitCount(a) - Integer.bitCount(b);
            return popcountDiff != 0 ? popcountDiff : a - b;
        });

        // Copy back to original array
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        return arr;
    }
}

