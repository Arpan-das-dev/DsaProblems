package TwoPointers;

/**
 * Utility class to sort an array of colors represented by integers 0, 1, and 2.
 *
 * <p>Given an array of integers where each element is 0 (red), 1 (white), or 2 (blue),
 * sort the array in place such that all 0s come first, followed by all 1s, then all 2s.</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 250}</b> and is commonly known as the Dutch National Flag problem.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use a three‑pointer technique with low, mid, and high pointers.</li>
 *   <li>low points to the next position for 0, high points to the next position for 2, and mid traverses the array.</li>
 *   <li>If nums[mid] is 0, swap with nums[low] and increment both pointers.</li>
 *   <li>If nums[mid] is 1, leave it and increment mid.</li>
 *   <li>If nums[mid] is 2, swap with nums[high] and decrement high.</li>
 *   <li>Continue until mid exceeds high.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n) where n = nums.length, as each element is visited at most once.<br>
 * <b>Space Complexity:</b> O(1) for constant extra space.</p>
 *
 * @author Arpan Das
 * @since 10/04/2026
 */
public class SortColors {

    /**
     * Sorts the array of colors in place to group 0s, 1s, and 2s sequentially.
     *
     * <p>The method modifies the input array so that all 0s appear first, followed by 1s,
     * and then 2s, without using extra space. Null or empty arrays are handled gracefully.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: nums = [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     *
     * Input: nums = [2,0,1]
     * Output: [0,1,2]
     * </pre>
     *
     * @param nums non‑null array of integers 0, 1, or 2; may be empty
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swapIt(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swapIt(nums, mid, high);
                high--;
            }
        }
    }

    /**
     * Helper method to swap two elements in an integer array.
     *
     * <p>Exchanges the values at indices low and mid in the array nums.</p>
     *
     * @param nums non‑null integer array
     * @param low index of the first element
     * @param mid index of the second element
     */
    private void swapIt(int[] nums, int low, int mid) {
        int temp = nums[low];
        nums[low] = nums[mid];
        nums[mid] = temp;
    }
}
