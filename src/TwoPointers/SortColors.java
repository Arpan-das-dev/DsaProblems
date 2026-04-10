package TwoPointers;

public class SortColors {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;

        int low = 0, mid = 0, high = nums.length-1;
        while (mid <= high){
            if(nums[mid] == 0){
                swapIt(nums,low,mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swapIt(nums,mid,high);
                high--;
            }
        }
    }

    private void swapIt(int[] nums, int low, int mid) {
        int temp = nums[low];
        nums[low] = nums[mid];
        nums[mid] = temp;
    }
}
