package Greedy;

public class JumpGame1 {
    // [2,3,1,1,4] [3,2,1,0,4]
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int index = 0; index < nums.length; index++) {
            if(index > maxReach) return false; // simple game over
            maxReach = Math.max(maxReach, index+nums[index]);
            // so index + means how far we can jump from current index with its value
        }
        return true;
    }
}
