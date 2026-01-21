package Hashing;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to encode and decode a list of strings into a single string for transmission/storage.
 *
 * <p>This implements a simple, robust encoding scheme where each string is prefixed with
 * its length followed by a delimiter (e.g., '#'). This allows the receiver to correctly
 * split the concatenated string even if the original strings contain any characters,
 * including delimiters.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li><b>Encode:</b> For each string, append its length, then a '#', then the string itself.</li>
 *   <li><b>Decode:</b> Iterate through the encoded string, locate each '#', parse the length,
 *       extract the next <code>length</code> characters as the original string, and advance the index.</li>
 * </ul>
 *
 * <p>This guarantees that the decoding is unambiguous, even if the original strings contain '#' or other special characters.</p>
 *
 * <p><b>Time Complexity:</b> O(N) for both encode and decode, where N is the total length of all strings.<br>
 * <b>Space Complexity:</b> O(N) for the encoded string and decoded list.</p>
 *
 * @author Arpan Das
 * @since 21/01/2026
 */
public class EncodeDecodeString {

    /**
     * Encodes a list of strings into a single string for safe transmission or storage.
     *
     * <p>Each string is encoded as: {@code [length]#[string]}. For example:
     * <pre>
     *   Input:  ["hello", "world"]
     *   Output: "5#hello5#world"
     * </pre>
     * This format allows the receiver to correctly split the string even if the original
     * strings contain arbitrary characters (including '#').</p>
     *
     * @param strs an array of strings to encode
     * @return the encoded string where each string is prefixed by its length and '#'
     */
    public String encode(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    /**
     * Decodes a single encoded string back into the original array of strings.
     *
     * <p>Decodes the format produced by {@code encode()}: for each segment,
     * locate the next '#', read the length, then extract the next <code>length</code> characters as a string.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input:  "5#hello5#world"
     * Output: ["hello", "world"]
     *
     * Input:  "0##4#test"
     * Output: ["", "test"]
     *
     * Input:  "3#abc1#1"
     * Output: ["abc", "1"]
     * </pre>
     *
     * @param encoded the encoded string from {@code encode()}
     * @return the original array of strings
     */
    public String[] decode(String encoded) {
        List<String> decoded = new ArrayList<>();
        int start = 0;
        int end = encoded.length();

        while (start < end) {
            int hashPosition = encoded.indexOf('#', start);  // Find the delimiter '#'
            int length = Integer.parseInt(encoded.substring(start, hashPosition)); // Parse the length

            int startPositon = hashPosition + 1;       // Start of the actual string
            int endPosition = startPositon + length;   // End of the actual string
            String decode = encoded.substring(startPositon, endPosition);
            decoded.add(decode);

            start = endPosition; // Move to the start of next segment
        }
        return decoded.toArray(new String[0]);
    }
}

