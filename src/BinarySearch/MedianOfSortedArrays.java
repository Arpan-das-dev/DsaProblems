package BinarySearch;

/**
 * Utility class to find median of two sorted arrays in O(log(min(m,n))) time.
 *
 * <p>Given two sorted arrays {@code nums1} and {@code nums2} of size m and n, return median
 * of merged sorted array. Median = middle element (odd total) or average of two middles (even).</p>
 *
 * <p><b>Approach:</b> Binary Search on Partition Point</p>
 * <ul>
 *   <li>Ensure nums1 shorter (binary search smaller array)</li>
 *   <li>Find partition i in nums1, j=(m+n+1)/2-i in nums2</li>
 *   <li>Valid partition: nums1[i-1] ≤ nums2[j] and nums2[j-1] ≤ nums1[i]</li>
 *   <li>Median from partition boundaries</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(log(min(m,n))).<br>
 * <b>Space Complexity:</b> O(1).</p>
 *
 * @author Arpan Das
 * @since 23/02/2026
 */
public class MedianOfSortedArrays {

    /**
     * Returns median of two sorted arrays.
     *
     * <p>Uses binary search to find optimal partition splitting combined array into equal halves.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: nums1 = [1,3], nums2 = [2]
     * Output: 2.0
     * Merged: [1,2,3] → median=2 ✓
     *
     * Input: nums1 = [1,2], nums2 = [3,4]
     * Output: 2.5
     * Merged: [1,2,3,4] → (2+3)/2=2.5 ✓
     *
     * Input: nums1 = [0,0], nums2 = [0,0]
     * Output: 0.0
     *
     * Input: nums1 = [], nums2 = [1]
     * Output: 1.0
     * </pre>
     *
     * @param nums1 first sorted array
     * @param nums2 second sorted array
     * @return median of merged array
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        boolean evenTotal = (m + n) % 2 == 0;
        int halfLen = (m + n + 1) / 2;  // Length of left partition (+1 for odd)

        // Binary search for correct partition
        while (left <= right) {
            int partitionA = (left + right) / 2;           // Cut in nums1
            int partitionB = halfLen - partitionA;         // Cut in nums2

            // Get left/right boundary values (sentinels for edges)
            int leftA = partitionA == 0 ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int rightA = partitionA == m ? Integer.MAX_VALUE : nums1[partitionA];
            int leftB = partitionB == 0 ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int rightB = partitionB == n ? Integer.MAX_VALUE : nums2[partitionB];

            // Check if valid partition
            if (leftA <= rightB && leftB <= rightA) {
                // Correct partition found
                if (evenTotal) {
                    // Average of right boundaries for even total
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                } else {
                    // Max left boundary for odd total
                    return Math.max(leftA, leftB);
                }
            } else if (leftA > rightB) {
                // Move partitionA left
                right = partitionA - 1;
            } else {
                // Move partitionA right
                left = partitionA + 1;
            }
        }
        return 0.0;  // Should not reach here
    }
}
