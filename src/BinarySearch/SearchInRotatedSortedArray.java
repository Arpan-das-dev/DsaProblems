package BinarySearch;

/**
 * Utility class for searching a target value in a rotated sorted array
 * using a modified binary search.
 *
 * <p>The input array is originally sorted in ascending order, but then rotated
 * at an unknown pivot. The goal is to find the index of the target in O(log n)
 * time, or return -1 if it does not exist.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use binary search with two pointers: left and right.</li>
 *   <li>At each step, determine which half (left or right) is sorted.</li>
 *   <li>If the target lies within the sorted half, discard the other half;
 *       otherwise search in the unsorted half.</li>
 * </ul>
 *
 * <p>This leverages the fact that in a rotated sorted array, at least one side
 * of the midpoint is always sorted, allowing logarithmic search time.[web:36][web:39]</p>
 *
 * <p><b>Time Complexity:</b> O(log n), where n is the number of elements in the array.<br>
 * <b>Space Complexity:</b> O(1), since only a few pointers and variables are used.[web:36]</p>
 *
 * @author Arpan Das
 * @since 09/01/2026
 */
public class SearchInRotatedSortedArray {

    /**
     * Searches for a target value in a rotated sorted array.
     *
     * <p>If the target exists, its index is returned; otherwise, -1 is returned.
     * The search is performed using a modified binary search that accounts for
     * the rotation.[web:36][web:39]</p>
     *
     * @param num    a rotated sorted array of integers
     * @param target the value to search for
     * @return the index of the target if found; otherwise -1
     */
    public int search(int[] num, int target) {
        int left = 0;
        int right = num.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (num[mid] == target) return mid;

            // Left half is sorted
            if (num[left] <= num[mid]) {
                // Target lies within the sorted left half
                if (num[left] <= target && target < num[mid]) {
                    right = mid - 1;
                } else { // Search in the right half
                    left = mid + 1;
                }
            } else { // Right half is sorted
                // Target lies within the sorted right half
                if (num[mid] < target && target <= num[right]) {
                    left = mid + 1;
                } else { // Search in the left half
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
