package DynamicProgramming;

public class TargetSum {
    private int count;

    public int findTargetSumWaysBrute(int[] nums, int target) {
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

    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int item : nums) totalSum+= item;
        // check validation can we break it into two + and - groups?
        if((target+totalSum) %2 != 0 || Math.abs(target) > totalSum) return 0;

        int subSetSum = (totalSum+target)/2;
        int [] dp = new int[subSetSum+1];
        dp[0] = 1;

        for (int item: nums){
            for (int i = subSetSum; i >= item ; i--) {
                dp[i] += dp[i-item];
            }
        }
        return dp[subSetSum];
    }
}
