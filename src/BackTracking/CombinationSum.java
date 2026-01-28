package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(candidates,target,0,new ArrayList<Integer>(),result);
        return result;
    }

    private void backTrack
            (int[] candidates, int target, int index, ArrayList<Integer> current, List<List<Integer>> result)
    {
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if(target < 0 || index >= candidates.length) {
            return;
        }

        // add into current array just for a choice
        current.add(candidates[index]);
        // pick current element
        backTrack(candidates,target-candidates[index],index,current,result);
        current.removeLast();

        // pick the next one
        backTrack(candidates,target,index+1,current,result);
    }
}
