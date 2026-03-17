package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;

        Arrays.sort(nums);
        backTrack(nums,result,0,new ArrayList<Integer>());
        return result;
    }

    private void backTrack(int[] nums, List<List<Integer>> result, int i, ArrayList<Integer> subset) {
        result.add(new ArrayList<>(subset));

        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) continue;

            subset.add(nums[j]);
            backTrack(nums, result, j + 1, subset);
            subset.removeLast();
        }
    }
}
