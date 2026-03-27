package BackTracking;

public class TargetSum {
    private int count;

    public int findTargetSumWays(int[] nums, int target) {
        count = 0;
        backTrack(nums,target,0);
        return count;
    }

    private void backTrack(int[] nums, int target, int i) {
        if(i == nums.length) {
            if(target == 0) count++;
            return;
        }

        int value = nums[i];
        backTrack(nums,target-value,i+1);
        backTrack(nums,target+value,i+1);
    }
}
