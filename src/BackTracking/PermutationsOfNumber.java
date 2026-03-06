package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfNumber {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;

        boolean[] used = new boolean[nums.length];
        backTrack(nums,result,used,new ArrayList<Integer>());

        return result;
    }

    private void backTrack(int[] nums, List<List<Integer>> result, boolean[] used, ArrayList<Integer> integers) {
        if(integers.size() == nums.length) {
            result.add(new ArrayList<>(integers));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            used[i] = true;
            integers.add(nums[i]);
            backTrack(nums, result, used, integers);
            used[i] = false;
            integers.removeLast();
        }
    }
}
