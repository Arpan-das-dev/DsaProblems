package Stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class CarFleet {
    // target = 12
    //position = [10, 8, 0, 5, 3]
    //            2, 4, 12, 7,9
    //speed   = [2, 4, 1, 1, 3]
    // 1,1,7,3,12  1,1,3,7,12
    public int carFleet(int target, int[] position, int[] speed) {
        double[] times = new double[position.length];
        for (int i = 0; i < position.length; i++) {
            times[i] = ((double) (target - position[i]) /speed[i]);
        }
        Stack<Double> fleets = new Stack<>();
    }
}
