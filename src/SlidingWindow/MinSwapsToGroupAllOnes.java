package SlidingWindow;

public class MinSwapsToGroupAllOnes {
    public int minSwaps(int[] nums) {
        int totalOne = 0;
        for(int item : nums) {
            if(item == 1) totalOne++;
        }

        int left = 0;
        int zeros = 0;
        int min = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) zeros ++;
            int window = right-left+1;

            if(window == totalOne){
                min = Math.min(min,zeros);
                if(nums[left] == 0) zeros --;
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
