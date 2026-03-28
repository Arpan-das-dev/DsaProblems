package BinarySearch;

/**
 * Utility class to find peak index in mountain array using binary search.
 *
 * <p>LeetCode 852: Given mountain array {@code arr} where arr[0] < arr[1] < ... < arr[i] > arr[i+1] > ... > arr[n-1],
 * return index i (peak). Guaranteed to exist.</p>
 *
 * <p><b>Approach:</b> Binary Search on Peak Property</p>
 * <ul>
 *   <li>If arr[mid] < arr[mid+1] → ascending, peak right</li>
 *   <li>Else → descending, peak left (or at mid)</li>
 *   <li>Converge to peak index</li>
 * </ul>
 *
 * <p>{@code @code Time: O(log n), Space: O(1)}<p>
 *
 * @author Arpan Das
 * @since 28/03/2026
 */
public class PeakIndexInAMountainArray {

    /**
     * Returns peak index using binary search.
     *
     * <p>Eliminates half of search space each iteration based on slope.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: arr = [0,1,0]
     * Peak at index 1 → Output: 1 ✓
     *
     * Input: arr = [0,2,1,0]
     * Peak at index 1 → Output: 1
     *
     * Input: arr = [0,10,5,2]
     * Peak at index 1 → Output: 1
     *
     * Input: arr = [3,5,3,2,0]
     * Peak at index 1 → Output: 1
     * </pre>
     *
     * @param arr mountain array (ascending then descending)
     * @return peak index
     */
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // Ascending slope → peak is right
                left = mid + 1;
            } else {
                // Descending slope → peak is left or at mid
                right = mid;
            }
        }

        return left;  // left == right at peak
    }
}