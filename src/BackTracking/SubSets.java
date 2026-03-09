package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        backTrack(nums,result,new ArrayList<Integer>(),0);
        return result;
    }

    private void backTrack(int[] nums, List<List<Integer>> result, ArrayList<Integer> subset, int start) {
        if(start == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[start]);
        backTrack(nums,result,subset,start+1);
        subset.removeLast();
        backTrack(nums,result,subset,start+1);
    }
}
// 1,2,3 [],[1],[1,2],[1,2,3],[2