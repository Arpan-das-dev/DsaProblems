package DynamicProgramming;
/**
 * Solves the classic House Robber problem using Dynamic Programming.
 *
 * <p>Problem summary:
 * You are given a list of houses, each containing some amount of money.
 * You cannot rob two adjacent houses due to a security system.
 * The goal is to determine the maximum amount of money you can rob
 * without triggering the alarm.</p>
 *
 * <p><b>Approach:</b>
 * <ul>
 *   <li>At each house, you have two choices:
 *     <ul>
 *       <li><b>Pick</b> the current house (then you must skip the previous one)</li>
 *       <li><b>Skip</b> the current house (keep the previous maximum)</li>
 *     </ul>
 *   </li>
 *   <li>The optimal solution at the current house depends only on the
 *       optimal solutions of the previous two houses.</li>
 * </ul>
 *
 * <p>This implementation uses a space-optimized Dynamic Programming approach
 * with constant extra space.</p>
 *
 * <p><b>Time Complexity:</b> O(n) — where n is the number of houses<br>
 * <b>Space Complexity:</b> O(1) — constant extra space</p>
 *
 * @author Arpan Das
 * @since 01/01/2026
 */
public class HouseRobber1 {
    /**
     * Calculates the maximum amount of money that can be stolen
     * without robbing two adjacent houses.
     *
     * @param money an array where each element represents the amount
     *              of money in a house
     * @return the maximum money that can be stolen safely
     */
    public int maxMoneyStolen(int[] money) {
        // Edge case: no houses
        if (money.length == 0) return 0;
        // Edge case: only one house
        if (money.length == 1) return money[0];
        // previous1 -> maximum money stolen up to the previous house
        int previous1 = 0;
        // previous2 -> maximum money stolen up to two houses back
        int previous2 = 0;
        for (int amount : money) { // starting loop
            // Option 1: pick the current house
            // If we pick this house, we must add its money to previous2
            int pick = previous2 + amount;

            // Option 2: skip the current house
            // If we skip, we keep whatever we had till the previous house
            int skip = previous1;

            // Choose the better of the two options
            int current = Math.max(pick, skip);

            // Move the DP window forward
            previous2 = previous1;
            previous1 = current;
        }
        return previous1;
    }
}
