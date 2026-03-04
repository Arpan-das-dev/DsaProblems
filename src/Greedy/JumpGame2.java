package Greedy;

public class JumpGame2 {
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;

        int maxReach = 0;
        int steps = 0;
        int lastJump = 0;

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            maxReach = Math.max(maxReach,i+curr);
            if(i == lastJump){
                steps++;
                lastJump = maxReach;
            } if(lastJump >= nums.length-1) return steps;
        }
        return steps;
    }
}
