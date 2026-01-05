package Hashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> keyTargetMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int key = target - numbers[i];
            if(keyTargetMap.containsKey(key)) {
                return new int[] {keyTargetMap.get(key),i};
            }
            keyTargetMap.put(numbers[i],i);
        }
        return new int[] {};
    }
}
