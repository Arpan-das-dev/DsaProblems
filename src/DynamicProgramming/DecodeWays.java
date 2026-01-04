package DynamicProgramming;

/**
 * Utility class for calculating the number of possible decoding of a numeric string
 * based on the traditional A-Z mapping rule where 'A' -> 1, 'B' -> 2, ..., 'Z' -> 26.
 *
 * <p>Each valid numeric sequence can represent a combination of one or two digits
 * depending on its position and validity within the range (1–26).</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Uses dynamic programming to store intermediate decoding counts.</li>
 *   <li>For each position, consider both single-digit (1–9) and double-digit (10–26) possibilities.</li>
 *   <li>Builds up the total number of decoding using the recurrence:</li>
 * </ul>
 *
 * <pre>
 *   ways[i] = ways[i - 1]   if one-digit number is valid
 *          + ways[i - 2]   if two-digit number is valid
 * </pre>
 *
 * <p>This avoids redundant recursion and ensures linear-time performance.</p>
 *
 * <p><b>Time Complexity:</b> O(n), where n is the length of the string<br>
 * <b>Space Complexity:</b> O(n), due to the memoization array storing subproblem results.</p>
 *
 * @author Arpan Das
 * @since 04/01/2025
 */
public class DecodeWays {

    /**
     * Determines the number of possible decoding for the input numeric string.
     *
     * <p>Each character or pair of characters can represent one or two letters
     * depending on their numeric value (1–26). Zeros are treated carefully since
     * they cannot represent any valid letter individually.</p>
     *
     * @param s the numeric string consisting only of digits '0'–'9'
     * @return the total count of possible decoding; returns 0 for invalid or empty strings
     */
    public int numDecoding(String s) {
        if (s == null || s.isEmpty()) return 0; // return zero for empty or null string;
        int length = s.length();

        int[] memoization = new int[length + 1]; // creating a new array with length of the string + 1
        memoization[0] = 1; // if the length of string = 0 then ways of decode = 1
        memoization[1] = s.charAt(0) == '0' ? 0 : 1; // check if it's zero
                                                    // then way of decode is 0 otherwise 1

        for (int i = 2; i <= length; i++) { // as we populated already
                                           //  so the value of first two index so i = 2
            int oneDigit = Integer.parseInt(s.substring(i - 1, i)); // getting exact the digit 11>x>0
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));  // getting two digit with
                                                                 // current index and previous index 26>x>10

            if (oneDigit >= 1) {
                memoization[i] += memoization[i - 1]; // if one digit is valid then increment i th position
                                                      // with the value of i-1
            }
            if (twoDigit >= 10 && twoDigit <= 26) {
                memoization[i] += memoization[i - 2]; // if two digit is valid then increment ith position
                                                      // with the value of i-2
            }
        }
        return memoization[length];
    }
}
