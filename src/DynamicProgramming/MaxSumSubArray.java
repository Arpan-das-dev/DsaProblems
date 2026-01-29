package DynamicProgramming;

public class MaxSumSubArray {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        // at current index max sum of the subArray
        int subSumEnds = nums[0];
        // max subArray seen so far
        int maxSumSeen = nums[0];

        for (int index = 1; index < nums.length; index++) {
            subSumEnds = Math.max(nums[index],subSumEnds+nums[index]);
            maxSumSeen = Math.max(subSumEnds,maxSumSeen);
        }
        return maxSumSeen;
    }
}
