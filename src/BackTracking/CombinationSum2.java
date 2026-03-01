package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);
        backTracking(candidates,target,0,result,new ArrayList<Integer>());
        return result;
    }

    private void backTracking(int[] candidates, int target,
                              int start, List<List<Integer>> result, ArrayList<Integer> combination)
    {
        if(target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i-1]) continue;
            int curr = candidates[i];
            if(curr > target) break;
            combination.add(curr);
            backTracking(candidates,target-curr,i+1,result,combination);
            combination.removeLast();
        }
    }
}
