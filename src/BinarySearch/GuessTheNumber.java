package BinarySearch;

/**
 * Utility class to simulate a "Guess the Number" game using binary search.
 *
 * <p>In the game, a number is secretly picked between 1 and n inclusive. For each guess,
 * the system responds with -1 (your guess is too high), 1 (your guess is too low),
 * or 0 (your guess is correct). The goal is to find the picked number in as few guesses as possible.</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 250}</b>.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use binary search over the range [1, n] to minimize the number of guesses.</li>
 *   <li>At each step, guess the middle value (mid) of the current valid range.</li>
 *   <li>If the guess is too high (response -1), adjust the upper bound to mid - 1.</li>
 *   <li>If the guess is too low (response 1), adjust the lower bound to mid + 1.</li>
 *   <li>If the guess is correct (response 0), return mid.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(log n) due to binary search over the range 1 to n.<br>
 * <b>Space Complexity:</b> O(1) for constant extra space.</p>
 *
 * @author Arpan Das
 * @since 10/04/2026
 */
public class GuessTheNumber {
    private final int picked;

    /**
     * Constructs a GuessTheNumber instance with a pre‑picked number.
     *
     * <p>The picked number is stored internally and used by the guess helper method to simulate
     * the game response for each guess.</p>
     *
     * @param picked the secret number to guess (between 1 and some n)
     */
    public GuessTheNumber(int picked) {
        this.picked = picked;
    }

    /**
     * Guesses the number using binary search within the range 1 to n.
     *
     * <p>The method repeatedly calls the guess helper with the middle value until the correct
     * number is found, then returns it. If the range is invalid, -1 is returned (though
     * in the game context this should not occur).</p>
     *
     * <p><b>Example:</b></p>
     * <pre>
     * Input: n = 10, picked = 6
     * Output: 6
     * Explanation:
     *   guess(10) returns 0 → 6 is found.
     * </pre>
     *
     * @param n the upper bound of the guessing range (1 ≤ guessNumber ≤ n)
     * @return the picked number if found, or -1 if not found (should not occur in valid input)
     */
    public int guessNumber(int n) {
        int max = n;
        int min = 1; // Changed from 0 to 1 for inclusive range [1,n]
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int res = guess(mid);

            switch (res) {
                case 0 -> {
                    return mid;
                }
                case -1 -> max = mid - 1;
                default -> min = mid + 1;
            }
        }
        return -1;
    }

    /**
     * Helper method to simulate the guess response for a given number.
     *
     * <p>Returns -1 if the guess is too high, 1 if too low, or 0 if correct,
     * using the stored picked number.</p>
     *
     * @param num the guessed number
     * @return -1 if num > picked, 1 if num < picked, 0 if num == picked
     */
    private int guess(int num) {
        return Integer.compare(picked, num);
    }
}
