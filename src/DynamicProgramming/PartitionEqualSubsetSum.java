package DynamicProgramming;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
       int sum = 0;
       for (int item : nums) sum+= item;
       // if not even sum can not be partitioned
       if(sum %2 != 0) return false;
       int target = sum/2;

       boolean [] dp = new boolean[target+1];
       dp[0] = true;

       for (int item: nums){
           for (int i = target; i >= item ; i--) {
               dp[i] = dp[i] || dp[i-item];
           }
       }
       return dp[target];
    }
}
