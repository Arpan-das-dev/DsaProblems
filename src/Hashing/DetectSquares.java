package Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Detects number of squares that can be formed with given query point as one corner.
 *
 * <p>Designs a detector that accepts multiple points (x,y coordinates) and queries how many
 * axis-aligned squares can be formed where the given query point is one of the four corners.
 * Points may be added multiple times (multiplicity handled via counts).</p>
 *
 * <p><b>Key Insight:</b> For query (x,y) and potential opposite corner (a,b):
 * <ul>
 *   <li>Side length = |x-a| = |y-b|</li>
 *   <li>Other corners: (x+side,y), (x,y+side), (x+side,y+side)</li>
 * </ul></p>
 *
 * <p><b>Examples:</b></p>
 * <pre>
 * add([3,10]), add([11,2]), add([3,2])
 * count([11,10]) → 1  // Forms square: (11,10),(11,2),(3,2),(3,10)
 * </pre>
 *
 * @author Arpan Das
 * @since 17/03/2026
 */

public class DetectSquares {

    /** Nested map: x → y → frequency of point (x,y) */
    private final Map<Integer, Map<Integer, Integer>> coordinates;

    /**
     * Constructs empty square detector with coordinate frequency map.
     */
    public DetectSquares() {
        this.coordinates = new HashMap<>();
    }

    /**
     * Adds point to coordinate collection, incrementing frequency if exists.
     *
     * <p>Uses nested HashMap structure: coordinates[x][y] += 1</p>
     *
     * @param point 2-element array [x, y] coordinates
     */
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        coordinates.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yMap = coordinates.get(x);
        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }

    /**
     * Counts axis-aligned squares with given point as one corner.
     *
     * <p><b>Algorithm:</b></p>
     * <ul>
     *   <li>For each y' ≠ y on same x: side = |y'-y|</li>
     *   <li>Check both directions: x+side and x-side</li>
     *   <li>Verify other corners exist: (x±side,y), (x±side,y')</li>
     *   <li>Multiply frequencies of all 4 corners</li>
     * </ul>
     *
     * @param point 2-element array [x, y] query corner
     * @return number of valid squares containing this point
     */
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];

        if (!coordinates.containsKey(x)) {
            return 0;
        }

        int count = 0;
        Map<Integer, Integer> yMap = coordinates.get(x);

        // Try each potential opposite corner y-coordinate
        for (int oppY : yMap.keySet()) {
            if (oppY == y) continue;  // Skip same point

            int sideLength = Math.abs(oppY - y);

            // Check square on right side (x + sideLength)
            int rightX = x + sideLength;
            long rightCount = (long) yMap.get(oppY)  // (x, oppY)
                    * coordinates.getOrDefault(rightX, new HashMap<>()).getOrDefault(y, 0)     // (rightX, y)
                    * coordinates.getOrDefault(rightX, new HashMap<>()).getOrDefault(oppY, 0); // (rightX, oppY)
            count += (int) rightCount;

            // Check square on left side (x - sideLength)
            int leftX = x - sideLength;
            long leftCount = (long) yMap.get(oppY)   // (x, oppY)
                    * coordinates.getOrDefault(leftX, new HashMap<>()).getOrDefault(y, 0)     // (leftX, y)
                    * coordinates.getOrDefault(leftX, new HashMap<>()).getOrDefault(oppY, 0); // (leftX, oppY)
            count += (int) leftCount;
        }

        return count;
    }
}
