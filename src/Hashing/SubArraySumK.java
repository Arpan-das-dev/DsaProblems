package Hashing;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefix = 0;
        int count = 0;

        for (int num : nums) {
            // increase prefix value
            prefix += num;
            // now check if the remaining complement part is present or not
            int key = prefix - k;
            if (map.containsKey(key)) {
                // if for such complement we found value then add it
                count += map.get(key);
            }
            // now current prefix will be the next key because it's maybe the complement of another sub array
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }
}
