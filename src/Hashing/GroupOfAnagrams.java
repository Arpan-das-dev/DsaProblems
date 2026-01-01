package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class for grouping strings that are anagrams of each other.
 *
 * <p>Two strings are considered anagrams if they contain the same characters
 * with the same frequencies, regardless of order.</p>
 *
 * <p><b>Approach:</b>
 * <ul>
 *   <li>Each string is converted into a frequency signature of 26 lowercase letters</li>
 *   <li>The frequency signature is serialized into a unique String key</li>
 *   <li>A HashMap is used to group strings sharing the same signature</li>
 * </ul>
 *
 * <p>This frequency-based approach avoids sorting and achieves optimal
 * performance.</p>
 *
 * <p><b>Time Complexity:</b> O(n × k), where n is the number of strings and
 * k is the average length of each string<br>
 * <b>Space Complexity:</b> O(n × k)</p>
 *
 * @author Arpan Das
 * @since 01/01/2025
 */
public class GroupOfAnagrams {
    /**
     * Groups a list of strings into collections of anagrams.
     *
     * <p>Strings that share the same character frequency signature are
     * grouped together.</p>
     *
     * @param strings an array of lowercase strings
     * @return a list of groups, where each group contains anagram strings
     */
    public List<List<String>> groupAnagrams(String [] strings) {
        Map<String , List<String>> stringListMap = new HashMap<>();

        for(String str : strings) {
            int [] frequencyArray = new int[26]; // initiating a 26 length array with '0' value
            for(char c : str.toCharArray()) {
                frequencyArray[c-'a']++; // increasing value as per char position in alphabet
                                            // eg- > e = 5-1, j = 10-1, t=20-1
            }
            // building unique signature key;
            StringBuilder key = new StringBuilder(); // using StringBuilder
                                                    // for efficient mutable string construction

            for(int i : frequencyArray) {
                key.append(i).append('#'); // generate a unique key with int value and # eg-> for 12 12#
            }
            // cheks the key is already present in the map
            // if yes then add the string into the list which generated the key
            // if not assign a new unique key with a new list adding that particular string
            // who generated that method
            /*
             * easy mode ->
             * if(map.containsKey(key) {
             * map.get(key).add(str)
             * } else {
             * map.put(key, new ArrayList()).add(key)
             * }
             */
            stringListMap.computeIfAbsent(key.toString(),string -> new ArrayList<>())
                    .add(str);
        }
        return new ArrayList<>(stringListMap.values());
    }

}
