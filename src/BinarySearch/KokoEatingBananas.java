package BinarySearch;

/**
 * Utility class for solving the Koko Eating Bananas problem using binary search.
 *
 * <p>Koko needs to eat all banana piles within h hours, eating at a fixed speed
 * (bananas per hour). The goal is to find the minimum integer eating speed
 * such that all piles can be finished in time.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use binary search over possible speeds: from 1 to the maximum pile size.</li>
 *   <li>For each candidate speed, compute the total hours required to eat all piles
 *       using ceiling division: {@code ceil(pile / speed)}.</li>
 *   <li>If the total time is within the allowed hours, try a smaller speed;
 *       otherwise, increase the speed.</li>
 * </ul>
 *
 * <p>This transforms the optimization problem into a decision problem solvable
 * in logarithmic time over the search space.</p>
 *
 * <p><b>Time Complexity:</b> O(n × log(maxPile)), where n is the number of piles.<br>
 * <b>Space Complexity:</b> O(1), only a few variables used.</p>
 *
 * @author Arpan Das
 * @since 12/01/2026
 */
public class KokoEatingBananas {

    /**
     * Finds the minimum eating speed (bananas per hour) such that Koko can eat
     * all banana piles within h hours.
     *
     * <p>The speed is chosen so that the total time to eat all piles (using ceiling
     * division per pile) does not exceed h.</p>
     *
     * @param piles array where piles[i] is the number of bananas in pile i
     * @param h     the maximum number of hours available
     * @return the minimum integer eating speed required
     */
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1; // default speed can eat one per hour
        int maxSpeed = 0; // max speed == max item of the array;
        for (int banana : piles){
            maxSpeed = Math.max(banana,maxSpeed); // assign the max item of the array;
        }
        while (minSpeed < maxSpeed) { // running the binary search
            int mid = minSpeed + (maxSpeed-minSpeed)/2; // calculating mid position
            if(canEat(mid,piles,h)) maxSpeed = mid; // he can eat let's try with smaller.
            else minSpeed = mid + 1; // too slow update the pointer
        }
        return minSpeed; // as per question requested to get min speed
    }

    /**
     * Helper method to check if Koko can eat all piles at the given speed within h hours.
     *
     * <p>Computes total time as sum of {@code ceil(pile / speed)} for each pile.</p>
     *
     * @param speed the eating speed in bananas per hour
     * @param piles the array of banana piles
     * @param time  the maximum allowed time in hours
     * @return true if all piles can be eaten within time, false otherwise
     */
    private boolean canEat(int speed, int[] piles, int time) {
        int timeTaken = 0;
        for (int banana : piles) {
            timeTaken += (int) Math.ceil((double) banana /speed); // updating the time values with ceil values
        }
        return timeTaken<=time; // if > return false if <=  returns true;
    }
}
