package BitManipulation;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public int singleNumberMapVersion(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num,freq.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> item : freq.entrySet()) {
            if(item.getValue() == 1) return item.getKey();
        }
        return -1;
    }

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) single^=num;
        return single;
    }
}
