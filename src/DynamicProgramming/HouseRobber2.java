package DynamicProgramming;

public class HouseRobber2 {
    public  int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        int pickFirst = robLinearHouses(nums,0,nums.length-1);
        int pickLast = robLinearHouses(nums,1,nums.length);

        return Math.max(pickFirst,pickLast);
    }

    private int robLinearHouses(int[] nums, int start, int limit) {
        int lastDay = 0;
        int twoDay = 0;

        for (int i = start; i < limit; i++) {
            int pick = twoDay + nums[i];
            int skip = lastDay;

            int current = Math.max(pick,skip);

            twoDay = lastDay;
            lastDay = current;
        }
        return lastDay;
    }
}
