package BinarySearch;

/**
 * Utility class to find the minimum element in a rotated sorted array.
 *
 * <p>Given a sorted array of unique integers rotated between 1 and n times, find the minimum element.
 * The array is guaranteed to be sorted in non-decreasing order before rotation.</p>
 *
 * <p><b>Approaches:</b></p>
 * <ul>
 *   <li><b>Brute Force:</b> Traverse the entire array and keep track of the minimum value.</li>
 *   <li><b>Optimal (Binary Search):</b> Exploit the fact that one half of the array around the midpoint
 *       is always sorted. Use binary search to discard the sorted half where the minimum cannot lie.</li>
 * </ul>
 *
 * <p>In the rotated array:
 * <ul>
 *   <li>The minimum element is the only point where the next element is smaller than the current one.</li>
 *   <li>The pivot point separates the array into two sorted halves.</li>
 * </ul>
 * Using binary search, we can discard the larger half and move into the half that must contain the minimum.</p>
 *
 * <p><b>Time Complexity:</b> O(n) for brute force, O(log n) for optimal.<br>
 * <b>Space Complexity:</b> O(1) for both.</p>
 *
 * @author Arpan Das
 * @since 21/01/2026
 */
public class FindMinInRotatedSortedArray {

    /**
     * Brute force solution to find the minimum element in a rotated sorted array.
     *
     * <p>Simply traverse the entire array from left to right, updating the minimum value seen so far.</p>
     *
     * @param nums a rotated sorted array of integers (non-empty, unique values)
     * @return the minimum element in the array
     */
    public int findMinBrute(int[] nums) {
        int min = nums[0];
        for (int item : nums) {
            min = Math.min(min, item);
        }
        return min;
    }

    /**
     * Optimized binary search solution to find the minimum element in a rotated sorted array.
     *
     * <p>Uses the property that in a rotated sorted array, one half around the middle is always sorted.
     * The minimum lies in the half that is not in ascending order.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input:  [3,4,5,1,2]
     * Output: 1
     * Explanation: The original sorted array was [1,2,3,4,5]. Rotated 1 time → [3,4,5,1,2].
     *              The minimum element is 1.
     *
     * Input:  [4,5,6,7,0,1,2]
     * Output: 0
     * Explanation: The original sorted array was [0,1,2,4,5,6,7]. Rotated 3 times → [4,5,6,7,0,1,2].
     *              The minimum element is 0.
     *
     * Input:  [11,13,15,17]
     * Output: 11
     * Explanation: The array is rotated 0 times. Minimum is 11.
     * </pre>
     *
     * @param nums a rotated sorted array of integers (non-empty, unique values)
     * @return the minimum element in the array
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // The right half is not sorted; minimum is in the right half (mid + 1 to right)
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // The right half is sorted; minimum is in the left half (left to mid)
            else {
                right = mid;
            }
        }
        return nums[left];
    }
}

