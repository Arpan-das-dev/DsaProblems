package Graphs.Degree;

/**
 * Utility class to find the town judge among n labeled people.
 *
 * <p>In a town with n people labeled from 1 to n, there may exist a “town judge” defined by two rules:
 * <ul>
 *   >The judge trusts nobody.</li>
 *   >Everybody else in the town trusts the judge.</li>
 * </ul>
 * Given an array trust where trust[i] = [a, b] means person a trusts person b, determine whether such a judge exists
 * and return the judge’s label; otherwise, return -1.</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 250}</b>.</p>
 *
 * <p><b>Approach (in‑degree based scoring):</b></p>
 * <ul>
 *   >Model the relationships as a directed graph where each trust pair [a, b] is an edge a → b.</li>
 *   >Use an array indegree[1..n] that effectively tracks “score”: subtract 1 for each person a who trusts someone,
 *       and add 1 for each person b who is trusted.</li>
 *   >After processing all trust pairs, the judge (if any) must have indegree[i] = n − 1, because they are trusted
 *       by all n − 1 others and they trust nobody (so no outgoing edges penalize their score).</li>
 *   >Iterate over indices 1..n to find such a node; if none exists, return -1.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(t + n) where t = trust.length; the trust list is scanned once, and then the
 *   n‑sized array is scanned once.<br>
 * <b>Space Complexity:</b> O(n) for the indegree array.</p>
 *
 * @author Arpan Das
 * @since 16/04/2026
 */
public class FindTheJudge {

    /**
     * Returns the label of the town judge if one exists, -1 otherwise.
     *
     * <p>The judge is the only person who:
     * <ul>
     *   >Trusts nobody (out‑degree = 0), and</li>
     *   >Is trusted by all other n − 1 people (in‑degree = n − 1).</li>
     * </ul>
     * The method uses a single array to combine the in‑degree and out‑degree information as a net score.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: n = 2, trust = [[1,2]]
     * Output: 2
     * Explanation:
     *   Person 1 trusts 2; person 2 trusts nobody → 2 is the judge.
     *
     * Input: n = 3, trust = [[1,3],[2,3]]
     * Output: 3
     * Explanation:
     *   Both 1 and 2 trust 3; 3 trusts nobody → 3 is the judge.
     *
     * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
     * Output: -1
     * Explanation:
     *   3 trusts 1, so 3 does not satisfy the “trusts nobody” condition.
     * </pre>
     *
     * @param n number of people (labeled 1 to n)
     * @param trust array of trust pairs; each trust[i] = [a, b] means person a trusts person b
     * @return the label of the town judge, or -1 if no judge exists
     */
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n + 1];

        // For each trust [a, b]:
        // a gives trust (out‑edge) → decrement a’s score
        // b receives trust (in‑edge) → increment b’s score
        for (int[] t : trust) {
            indegree[t[0]]--;
            indegree[t[1]]++;
        }

        // The judge must be trusted by all n−1 others and trust nobody → score = n−1
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
