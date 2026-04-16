package DynamicProgramming;

import java.util.Arrays;

public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // max and min product ending at current index
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];

        // global maximum product
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            // if current number is negative, swap max and min
            if (current < 0) {
                int temp = maxEndingHere;
                maxEndingHere = minEndingHere;
                minEndingHere = temp;
            }

            // update max and min ending at current index
            maxEndingHere = Math.max(current, maxEndingHere * current);
            minEndingHere = Math.min(current, minEndingHere * current);

            // update global result
            result = Math.max(result, maxEndingHere);
        }

        return result;
    }
}
