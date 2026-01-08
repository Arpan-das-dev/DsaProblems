package BinarySearch;
/**
 * Utility class that implements the classic binary search algorithm
 * on a sorted array of integers.
 *
 * <p>Binary search efficiently finds the index of a target value by repeatedly
 * dividing the search interval in half, assuming the input array is sorted
 * in non-decreasing order.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Maintain two pointers: left (start) and right (end) of the current search range.</li>
 *   <li>Compute the middle index and compare its value with the target.</li>
 *   <li>If equal, return the index; if the middle value is smaller, search the right half;
 *       otherwise, search the left half.</li>
 *   <li>Repeat until the target is found or the search range becomes empty.</li>
 * </ul>
 *
 * <p>This approach significantly reduces the number of comparisons compared
 * to linear search and is optimal for searching in sorted arrays.</p>
 *
 * <p><b>Time Complexity:</b> O(log n), where n is the length of the array.<br>
 * <b>Space Complexity:</b> O(1), as it uses only a few extra variables.</p>
 *
 * @author Arpan Das
 * @since 08/01/2026
 */
public class BinarySearch {

    /**
     * Searches for the target value in a sorted integer array using binary search.
     *
     * <p>If the target exists in the array, its index is returned. If the target
     * is not found, the method returns -1.</p>
     *
     * @param num a sorted array of integers (in non-decreasing order)
     * @param target the value to search for in the array
     * @return the index of the target if found; otherwise -1
     */
    public int search(int[] num, int target) {
        int left = 0;
        int right = num.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // avoids potential overflow

            if (num[mid] == target) return mid;

            if (num[mid] < target) {
                left = mid + 1;    // discard left half
            } else {
                right = mid - 1;   // discard right half
            }
        }
        return -1;
    }
}
