package TwoPointers;

/**
 * Utility class to reverse a character array in place.
 *
 * <p>Given a character array, reverse the order of its elements such that the first character
 * becomes the last, the second becomes the second‑to‑last, and so on. The array is modified in place
 * and no extra space (except for a small number of temporary variables) is used.</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 250}</b>.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Two‑pointer approach: maintain a left pointer starting at 0 and a right pointer starting
 *       at the last index.</li>
 *   <li>Swap the characters at left and right pointers, then move left forward and right backward
 *       until they meet.</li>
 *   <li>Alternatively, iterate only up to len/2 and swap each position i with its mirror
 *       position len‑i‑1.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n) where n = s.length, since each element is swapped at most once.<br>
 * <b>Space Complexity:</b> O(1); the reversal is performed in place with only a constant amount
 * of extra space.</p>
 *
 * @author Arpan Das
 * @since 05/04/2026
 */
public class ReverseString {

    /**
     * Reverses the given character array using a swap‑based loop up to half the length.
     *
     * <p>The method swaps the element at index i with the element at index len‑i‑1 for
     * all 0 ≤ i < len/2, effectively reversing the entire array in place.</p>
     *
     * @param s non‑null character array to reverse
     */
    public void reverseStringSwapBased(char[] s) {
        int length = s.length / 2;
        for (int i = 0; i < length; i++) {
            swapIt(s, i, s.length - i - 1);
        }
    }

    /**
     * Helper method to swap two characters in a character array.
     *
     * <p>Swaps the elements at indices i and j in the array s. No bounds checking is performed.</p>
     *
     * @param s non‑null character array
     * @param i index of the first character
     * @param j index of the second character
     */
    private void swapIt(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    /**
     * Reverses the given character array using the two‑pointer technique.
     *
     * <p>Uses left and right pointers that start at the ends of the array and move toward each other,
     * swapping elements until they meet or cross.</p>
     *
     * @param s non‑null character array to reverse
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
