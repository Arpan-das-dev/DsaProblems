package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Utility class for finding all unique triplets in an array that sum to zero.
 *
 * <p>Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i ≠ j ≠ k and nums[i] + nums[j] + nums[k] == 0.[web:26][web:36]</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Sort the array first to enable two-pointer technique and duplicate skipping.[web:26]</li>
 *   <li>Fix the first element, then use left/right pointers to find two sum to the
 *       negative of the fixed element (-nums[i]).</li>
 *   <li>Skip duplicate values for the fixed element and during two-pointer movement
 *       to ensure unique triplets.</li>
 * </ul>
 *
 * <p>This classic algorithm reduces the problem from O(n³) brute force to O(n²)
 * by combining sorting with two-pointer search.[web:26][web:36]</p>
 *
 * <p><b>Time Complexity:</b> O(n²), where n is the length of the array.<br>
 * <b>Space Complexity:</b> O(1) extra space (excluding output list and sorting).[web:26]</p>
 *
 * @author Arpan Das
 * @since 09/01/2026
 */
public class ThreeSum {

    /**
     * Returns all unique triplets that sum to zero in the given array.
     *
     * <p>The result is returned as a list of lists, with each inner list containing
     * three integers that sum to zero. All triplets are unique (no duplicates).[web:26][web:36]</p>
     *
     * @param num the input array of integers
     * @return a list of lists containing all unique triplets summing to zero
     */
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(num); // Enable two-pointer and duplicate skipping
        int n = num.length;

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate fixed values
            if (i > 0 && num[i] == num[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum == 0) {
                    // Found valid triplet
                    lists.add(List.of(num[i], num[left], num[right]));

                    // Skip duplicates for left pointer
                    while (left < right && num[left] == num[left + 1]) left++;
                    // Skip duplicates for right pointer
                    while (left < right && num[right] == num[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Need larger sum
                } else {
                    right--; // Need smaller sum
                }
            }
        }
        return lists;
    }
}
