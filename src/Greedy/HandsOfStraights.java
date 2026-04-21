package Greedy;

import java.util.TreeMap;

/**
 * Utility class to check whether a hand of cards can be rearranged into straight‑valued groups.
 *
 * <p>Given an integer array hand representing the values on the cards and an integer groupSize, determine
 * whether it is possible to rearrange the cards into groups such that:
 * <ul>
 *   <li>Each group has exactly groupSize cards.</li>
 *   <li>The values in each group are consecutive integers (a straight, like 2,3,4,5).</li>
 * </ul>
 * All cards must be used exactly once.</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 250}</b>.</p>
 *
 * <p><b>Approach (greedy with TreeMap‑based frequency map):</b></p>
 * <ul>
 *   <li>First check whether the total number of cards is divisible by groupSize; if not, return false.</li>
 *   <li>Store the frequency of each card value in a TreeMap, which keeps keys in sorted order.</li>
 *   <li>While the map is non‑empty:
 *     <ul>
 *       <li>Take the smallest key (firstKey) as the start of the next straight.</li>
 *       <li>For the next groupSize − 1 consecutive values (firstKey + 1, firstKey + 2, …),
 *           check whether each value exists and has at least one occurrence.</li>
 *       <li>If any value is missing, return false.</li>
 *       <li>Decrement the frequency of each value in the group and remove the key when its count drops to 0.</li>
 *     </ul>
 *   </li>
 *   <li>If all cards can be grouped into such straights, return true.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n log n) where n = hand.length, due to TreeMap insertion and removal
 *   (log n per operation) over n distinct card values.<br>
 * <b>Space Complexity:</b> O(n) for the TreeMap storing card frequencies.</p>
 *
 * @author Arpan Das
 * @since 21/04/2026
 */
public class HandsOfStraights {

    /**
     * Determines whether the hand can be rearranged into groups of consecutive cards.
     *
     * <p>Each group must contain exactly groupSize cards whose values form a consecutive sequence.
     * All cards in hand must be used exactly once. If the total number of cards is not divisible
     * by groupSize, the method immediately returns false.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: hand = [1,2,4,2,3,5,3,4], groupSize = 4
     * Output: true
     * Explanation:
     *   Can form two groups: [1,2,3,4] and [2,3,4,5].
     *
     * Input: hand = [1,2,3,3,4,5,6,7], groupSize = 4
     * Output: false
     * Explanation:
     *   One group can be [1,2,3,4] but leftovers cannot form another valid 4‑card straight.
     *
     * Input: hand = [1,1,3,3], groupSize = 3
     * Output: false
     * Explanation:
     *   4 cards cannot be divided into groups of 3.
     * </pre>
     *
     * @param hand array of integers representing card values; must not be null
     * @param groupSize size of each group of consecutive cards (&gt; 0)
     * @return true if the hand can be rearranged into valid straight‑valued groups, false otherwise
     */
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // If total cards cannot be evenly divided into groups, return false
        if (hand.length % groupSize != 0) {
            return false;
        }

        // Store frequency of each card value in sorted order
        TreeMap<Integer, Integer> cardFreq = new TreeMap<>();
        for (int card : hand) {
            cardFreq.put(card, cardFreq.getOrDefault(card, 0) + 1);
        }

        // Greedily form straights from the smallest available card
        while (!cardFreq.isEmpty()) {
            int firstKey = cardFreq.firstKey();
            for (int i = 0; i < groupSize; i++) {
                int next = firstKey + i;
                if (!cardFreq.containsKey(next)) {
                    return false;
                }
                int count = cardFreq.get(next);
                if (count == 1) {
                    cardFreq.remove(next);
                } else {
                    cardFreq.put(next, count - 1);
                }
            }
        }
        return true;
    }
}
