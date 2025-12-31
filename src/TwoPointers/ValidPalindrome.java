package TwoPointers;

public class ValidPalindrome {
    /**
     * Checks whether a given string is a valid palindrome using a brute-force approach.
     *
     * <p>A string is considered a valid palindrome if:
     * <ul>
     *   <li>Only alphanumeric characters are considered</li>
     *   <li>Character case is ignored</li>
     *   <li>The sequence reads the same forwards and backwards</li>
     * </ul>
     *
     * <p><b>Approach:</b>
     * <ol>
     *   <li>Iterate through the input string</li>
     *   <li>Filter out non-alphanumeric characters</li>
     *   <li>Build two strings:
     *     <ul>
     *       <li>{@code reverse} → characters appended in original order</li>
     *       <li>{@code inverse} → characters prepended to reverse order</li>
     *     </ul>
     *   </li>
     *   <li>Compare both strings for equality</li>
     * </ol>
     *
     * <p><b>Time Complexity:</b> O(n²) — due to immutable string concatenation inside the loop
     * <br>
     * <b>Space Complexity:</b> O(n) — additional strings used for comparison
     *
     * <p><b>Note:</b> This implementation is intentionally brute-force for clarity.
     * A two-pointer approach can solve the same problem in O(n) time and O(1) space.
     *
     * @param s the input string to be checked
     * @return {@code true} if the string is a valid palindrome, otherwise {@code false}
     */
    public boolean palindromeBrute(String s) {
        if (s.isEmpty()) return true;

        String reverse = "";
        String inverse = "";

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                reverse = reverse + Character.toLowerCase(s.charAt(i));
                inverse = Character.toLowerCase(s.charAt(i)) + inverse;
            }
        }

        return reverse.equals(inverse);
    }

    /**
     * Checks whether a given string is a valid palindrome using an optimal
     * two-pointer approach.
     *
     * <p>A string is considered a valid palindrome if:
     * <ul>
     *   <li>Only alphanumeric characters are considered</li>
     *   <li>Uppercase and lowercase letters are treated as equal</li>
     * </ul>
     *
     * <p><b>Optimal Approach (Two Pointers):</b>
     * <ol>
     *   <li>Initialize two pointers:
     *     <ul>
     *       <li>{@code start} at the beginning of the string</li>
     *       <li>{@code end} at the end of the string</li>
     *     </ul>
     *   </li>
     *   <li>Move pointers inward while skipping non-alphanumeric characters</li>
     *   <li>Compare characters case-insensitively</li>
     *   <li>If any mismatch is found, return {@code false}</li>
     * </ol>
     *
     * <p>The algorithm terminates early as soon as a mismatch is detected,
     * making it highly efficient for large inputs.
     *
     * <p><b>Time Complexity:</b> O(n) — each character is visited at most once
     * <br>
     * <b>Space Complexity:</b> O(1) — constant extra space
     *
     * <p><b>Why this approach?</b>
     * <ul>
     *   <li>Avoids extra memory allocation</li>
     *   <li>Performs in a single pass</li>
     *   <li>Preferred solution in coding interviews</li>
     * </ul>
     *
     * @param s the input string to be checked
     * @return {@code true} if the string is a valid palindrome, otherwise {@code false}
     */
    public boolean palindrome(String s) {
        if (s.isEmpty()) return true;

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {

            // Skip non-alphanumeric characters from the start
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }

            // Skip non-alphanumeric characters from the end
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }

            char leftChar = Character.toLowerCase(s.charAt(start));
            char rightChar = Character.toLowerCase(s.charAt(end));

            if (leftChar != rightChar) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

}
