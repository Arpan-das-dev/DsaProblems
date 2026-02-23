package BinarySearch;

public class MedianOfSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high = m;
        boolean even = (m + n) % 2 == 0;

        while (low <= high) {
            int firstPartition = (low + high) / 2;
            int secondPartition = ((m + n + 1) / 2) - firstPartition;

            int leftA = (firstPartition == 0) ? Integer.MIN_VALUE : nums1[firstPartition - 1];
            int rightA = (firstPartition == m) ? Integer.MAX_VALUE : nums1[firstPartition];

            int leftB = (secondPartition == 0) ? Integer.MIN_VALUE : nums2[secondPartition - 1];
            int rightB = (secondPartition == n) ? Integer.MAX_VALUE : nums2[secondPartition];

            // left A < right B && right B < left A

            if (leftA <= rightB && leftB <= rightA) {
                if (even) {
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                } else return Math.max(leftA, leftB);
            } else if (leftA > rightB) {
                high = firstPartition - 1;
            } else {
                low = firstPartition + 1;
            }
        }
        return 0.0;
    }
}
