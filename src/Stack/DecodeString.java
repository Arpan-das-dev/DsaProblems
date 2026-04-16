package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Utility class to decode an encoded string containing repeated patterns.
 *
 * <p>Given an encoded string where the pattern is written as `k[encoded_string]`, the rule is:
 * repeat the `encoded_string` inside the brackets exactly `k` times. The patterns can be nested,
 * for example `3[a2[c]b]` becomes `accbaccbaccb`.</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 250}</b>.</p>
 *
 * <p><b>Approach (two‑stack with StringBuilder):</b></p>
 * <ul>
 *   <li>Use two stacks:
 *     <ul>
 *       <li>One for repeat counts (numbers before '[').</li>
 *       <li>One for the outer string context before entering a bracket.</li>
 *     </ul>
 *   </li>
 *   <li>Parse characters one by one:
 *     <ul>
 *       <li>If the character is a digit, build the current number.</li>
 *       <li>If the character is '[', push the current number and current string context onto their stacks,
 *           reset the current number to 0, and start a new current string.</li>
 *       <li>If the character is ']', pop the repeat count and the outer context, form the repeated
 *           string for the current inner part, and update the current string to context + repeated inner.</li>
 *       <li>For normal letters, append them to the current string.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n) in practice, where n is the length of the decoded output, but bounded
 *   by the nesting depth and repetition counts.<br>
 * <b>Space Complexity:</b> O(n) for the stacks and StringBuilder storage, where n is the length
 *   of the decoded string.</p>
 *
 * @author Arpan Das
 * @since 16/04/2026
 */
public class DecodeString {

    /**
     * Decodes the given encoded string according to the pattern k[encoded_string].
     *
     * <p>The input string may contain letters, digits, and square brackets forming patterns of the form
     * k[...], where the substring inside the brackets is repeated k times. The patterns can be nested.
     * If the input is null or empty, it is returned as is.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: s = "3[a]2[bc]"
     * Output: "aaabcbc"
     * Explanation:
     *   3[a] → "aaa", 2[bc] → "bcbc"
     *
     * Input: s = "3[a2[c]]"
     * Output: "accaccacc"
     * Explanation:
     *   First decode 2[c] → "cc", then 3[acc] → "accaccacc".
     * </pre>
     *
     * @param s encoded string; may be null or empty
     * @return the decoded string with all patterns expanded
     */
    public String decodeString(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        Deque<Integer> numbers = new ArrayDeque<>();
        Deque<String> strings = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();
        int number = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '[') {
                numbers.push(number);
                strings.push(current.toString());
                current = new StringBuilder();
                number = 0;
            } else if (ch == ']') {
                int repeat = numbers.pop();
                StringBuilder temp = new StringBuilder(strings.pop());
                temp.append(String.valueOf(current).repeat(Math.max(0, repeat)));
                current = temp;
            } else {
                current.append(ch);
            }
        }
        return current.toString();
    }
}