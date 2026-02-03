package Greedy;

/**
 * Utility class to find the starting gas station index for a complete circular route.
 *
 * <p>Given two integer arrays {@code gas} and {@code cost}, where {@code gas[i]} is the amount
 * of gas at station i and {@code cost[i]} is the cost to travel to the next station, return the
 * minimum starting index to complete a circular tour. If impossible, return -1.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Track two variables:
 *     <ul>
 *       <li>{@code totalSpent}: net gas for entire circuit (gas[i] - cost[i])</li>
 *       <li>{@code totalFuelHas}: net gas from current start point</li>
 *     </ul>
 *   </li>
 *   <li>Iterate through all stations:</li>
 *     <ul>
 *       <li>Add net gas (gas[i] - cost[i]) to both totals</li>
 *       <li>If {@code totalFuelHas < 0}, current start point fails → reset to next station</li>
 *     </ul>
 *   </li>
 *   <li>Key insight: If total gas ≥ total cost, the last valid start point works for circular route</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n), single pass through arrays.<br>
 * <b>Space Complexity:</b> O(1), only a few variables.</p>
 *
 * @author Arpan Das
 * @since 03/02/2026
 */
public class GasStation {

    /**
     * Returns the starting gas station index for a complete circular route, or -1 if impossible.
     *
     * <p>Uses greedy single-pass algorithm. If total gas < total cost anywhere, impossible.
     * Otherwise, the last point where fuel never went negative is the valid start.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input:  gas = [1,2,3,4,5], cost = [3,4,5,1,2]
     * Output: 3
     * Explanation: Start at index 3: 4-1=3, 5-2=3, 1-3=-2+3=1, 2-4=-2+1=-1+2=1, 3-5=-2+1=-1 → works.
     *
     * Input:  gas = [2,3,4], cost = [3,4,4]
     * Output: -1
     * Explanation: Total gas = 9 < total cost = 11 → impossible.
     *
     * Input:  gas = [5], cost = [2]
     * Output: 0
     * Explanation: Single station works.
     * </pre>
     *
     * @param gas  array where gas[i] = gas at station i
     * @param cost array where cost[i] = cost to travel from i to i+1
     * @return starting index or -1 if impossible
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSpent = 0;     // Net gas for entire circuit
        int totalFuelHas = 0;   // Net gas from current start point
        int startPoint = 0;     // Candidate starting station

        for (int i = 0; i < gas.length; i++) {
            int netGas = gas[i] - cost[i];
            totalSpent += netGas;
            totalFuelHas += netGas;

            // Current start point cannot complete circuit
            if (totalFuelHas < 0) {
                totalFuelHas = 0;   // Reset fuel for new start
                startPoint = i + 1; // Try next station as start
            }
        }

        // If total gas insufficient for entire circuit, impossible
        return totalSpent >= 0 ? startPoint : -1;
    }
}

