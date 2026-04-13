package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement2 {
    public List<Integer> majorityElementBrute(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;

        Map<Integer,Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num,freq.getOrDefault(num,0)+1);
        }

        for (int key : freq.keySet()) {
            if(freq.get(key) > nums.length/3) {
                result.add(freq.get(key));
            }
        }
        return result;
    }

    // boye-moore algorithm
    public List<Integer> majorityElement(int [] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;

        int firstCandidate = 0, secondCandidate = 0;
        int count1 = 0, count2 = 0;
        // find potential candidate
        for (int num : nums) {
            if(num == firstCandidate) {
                count1 ++;
            } else if (num == secondCandidate) {
                count2 ++;
            } else if (count1 == 0) {
                firstCandidate = num;
                count1 = 1; // appeared once
            } else if (count2 == 0) {
                secondCandidate = num;
                count2 = 1; // appeared once
            } else {
                count1 --;
                count2 --;
            }
        }

        // verification
        count1 = 0; count2 = 0;
        for (int num : nums) {
            if(num == firstCandidate) count1 ++;
            else if (num == secondCandidate) count2 ++;
        }

        if(count1 > nums.length/3) result.add(firstCandidate);
        if(count2 > nums.length/3) result.add(secondCandidate);

        return result;
    }
}
