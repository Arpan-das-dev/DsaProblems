package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        // build last index map
        Map<Character, Integer> lastIdx = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            lastIdx.put(s.charAt(i),i);
        }

        int prev = -1;
        int max = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            max = Math.max(max,lastIdx.get(curr));

            if(max == i){
                result.add(max-prev);
                prev = max;
            }
        }
        return result;
    }
}
