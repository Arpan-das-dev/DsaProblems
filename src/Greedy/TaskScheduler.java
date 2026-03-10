package Greedy;

import java.util.Arrays;

/**
 * Utility class to compute minimum time intervals to schedule tasks with cooldown.
 *
 * <p>Given array {@code tasks} (A-Z) and cooldown {@code n}, return minimum CPU time units to
 * schedule all tasks. Same task requires n idle units between consecutive executions.</p>
 *
 * <p><b>Approach:</b> Greedy Frequency Analysis + Slot Calculation</p>
 * <ul>
 *   <li>Count task frequencies, sort descending</li>
 *   <li>{@code maxFreq} = most frequent task frequency</li>
 *   <li>Create {@code (maxFreq-1)} cycles of {@code n+1} slots</li>
 *   <li>Fill idle slots with other tasks, last cycle with max-freq tasks</li>
 *   <li>Formula: {@code max(tasks.length, (maxFreq-1)*(n+1) + idleTasks)}</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(1) = O(26 log 26).<br>
 * <b>Space Complexity:</b> O(1).</p>
 *
 * @author Arpan Das
 * @since 10/03/2026
 */

public class TaskScheduler {

    /**
     * Returns minimum time units to schedule all tasks with cooldown n.
     *
     * <p>Greedy scheduling based on maximum frequency bottleneck.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: tasks=['A','A','A','B','B','B'], n=2
     * Freq: A:3, B:3 → maxFreq=3
     * Schedule: A _ _ A _ _ A B B B → 8 slots ✓
     * Output: 8
     *
     * Input: tasks=['A','A','A','B','B','B'], n=0
     * No cooldown → Output: 6 (just tasks.length)
     *
     * Input: tasks=['A','A','B','B','C'], n=1
     * Schedule: A B A B C → 5 ✓
     * Output: 5
     * </pre>
     *
     * @param tasks array of uppercase letters A-Z
     * @param n     cooldown between same tasks
     * @return minimum time intervals needed
     */
    public int leastInterval(char[] tasks, int n) {
        // Count frequencies (A-Z → 0-25)
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Sort descending: freq[25] = max frequency
        Arrays.sort(freq);
        int maxFreq = freq[25];

        // Available slots in (maxFreq-1) cycles: each cycle = n+1 slots
        int idleSlots = (maxFreq - 1) * n;

        // Fill idle slots with other tasks (descending frequency)
        for (int i = 24; i >= 0 && idleSlots > 0; i--) {
            idleSlots -= Math.min(idleSlots, freq[i]);
        }

        // Return max(tasks.length, required slots)
        return idleSlots > 0 ? tasks.length + idleSlots : tasks.length;
    }
}

