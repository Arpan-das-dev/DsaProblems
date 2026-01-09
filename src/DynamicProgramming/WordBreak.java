package DynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Utility class for solving the classic Word Break problem using dynamic programming.
 *
 * <p>Given a string and a dictionary of valid words, the goal is to determine
 * whether the string can be segmented into a space-separated sequence of one
 * or more dictionary words.[web:26][web:30]</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Convert the word dictionary into a {@link java.util.HashSet} for O(1) average lookup.[web:26]</li>
 *   <li>Use a boolean DP array where {@code dp[i]} indicates whether the substring {@code s[0..i-1]}
 *       can be segmented into dictionary words.[web:29][web:39]</li>
 *   <li>For each position {@code i}, check all possible partition points {@code j < i};
 *       if {@code dp[j]} is true and {@code s.substring(j, i)} is in the set, mark {@code dp[i]} true and break.[web:26][web:36]</li>
 * </ul>
 *
 * <p>This bottom-up DP avoids recomputation of overlapping subproblems and
 * efficiently decides segmentability of the string.[web:26][web:30]</p>
 *
 * <p><b>Time Complexity:</b> O(n²) in the worst case, where n is the length of the string
 * (due to the nested loop over indices).<br>
 * <b>Space Complexity:</b> O(n) for the DP array, plus O(m) for the dictionary set where m is total word length.[web:26][web:39]</p>
 *
 * @author Arpan Das
 * @since 09/01/2026
 */
public class WordBreak {

    /**
     * Determines whether the given string can be segmented into one or more
     * dictionary words.
     *
     * <p>The method uses a DP array where each position represents whether the
     * prefix up to that index can be formed using words from the dictionary.[web:26][web:29]</p>
     *
     * @param s        the input string to segment
     * @param wordDict the list of valid words forming the dictionary
     * @return {@code true} if the string can be segmented into dictionary words; otherwise {@code false}
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet<>(wordDict);
        boolean [] dp = new boolean[s.length()+1];

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && dictionary.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
