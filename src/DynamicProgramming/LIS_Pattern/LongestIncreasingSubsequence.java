package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Utility class for solving the Longest Increasing Subsequence (LIS) problem.
 *
 * <p>The Longest Increasing Subsequence (LIS) problem is defined as finding
 * the length of the longest subsequence in an array such that all elements
 * of the subsequence are in strictly increasing order.</p>
 *
 * <p>This class provides two approaches:</p>
 * <ul>
 *   <li>A classic Dynamic Programming solution with O(n²) time complexity</li>
 *   <li>An optimized solution using Binary Search with O(n log n) time complexity</li>
 * </ul>
 *
 * <p>The optimized approach does not construct the actual subsequence,
 * but efficiently computes its length.</p>
 *
 * @author Arpan Das
 * @since 01/01/2025
 */
public class LongestIncreasingSubsequence {

    /**
     * Computes the length of the Longest Increasing Subsequence using
     * Dynamic Programming (brute-force approach).
     *
     * <p><b>Approach:</b></p>
     * <ul>
     *   <li>Define {@code dp[i]} as the length of the LIS ending at index {@code i}</li>
     *   <li>Initialize all {@code dp[i] = 1} since every element is an LIS of length 1</li>
     *   <li>For each element, compare it with all previous elements</li>
     *   <li>If {@code num[i] > num[j]}, update {@code dp[i] = max(dp[i], dp[j] + 1)}</li>
     * </ul>
     *
     * <p>This solution explicitly computes LIS for every prefix of the array.</p>
     *
     * <p><b>Time Complexity:</b> O(n²)</p>
     * <p><b>Space Complexity:</b> O(n)</p>
     *
     * @param num the input array of integers
     * @return the length of the longest increasing subsequence
     */
    public int lengthOfLISBrute(int[] num) {
       if(num == null || num.length == 0) return 0;
       int[] dp = new int[num.length];
        Arrays.fill(dp,1);
        int max = 1;
        for (int i = 1; i < num.length; i++) {
            for (int j = 0; j < i; j++) {
                if(num[i] > num[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    /**
     * Computes the length of the Longest Increasing Subsequence using
     * an optimized approach with Binary Search.
     *
     * <p><b>Core Idea:</b></p>
     * <ul>
     *   <li>Maintain a list where index {@code i} stores the smallest possible
     *       tail value of an increasing subsequence of length {@code i + 1}</li>
     *   <li>For each number, use binary search to find its correct position</li>
     *   <li>Replace existing values to keep future subsequences extendable</li>
     * </ul>
     *
     * <p><b>Important:</b> This method does not store the actual subsequence.
     * The size of the list represents the length of the LIS.</p>
     *
     * <p><b>Time Complexity:</b> O(n log n)</p>
     * <p><b>Space Complexity:</b> O(n)</p>
     *
     * @param num the input array of integers
     * @return the length of the longest increasing subsequence
     */
    public int lengthOfLIS(int[] num) {
        if (num == null || num.length == 0) return 0;

        List<Integer> tails = new ArrayList<>();

        for (int number : num) {
            int left = 0, right = tails.size();

            // binary search for first element >= num
            while (left < right) {
                int mid = (left + right) / 2;
                if (tails.get(mid) < number) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (left == tails.size()) {
                tails.add(number);     // extend LIS
            } else {
                tails.set(left, number); // replace to keep tail minimal
            }
        }

        return tails.size();
    }

}
