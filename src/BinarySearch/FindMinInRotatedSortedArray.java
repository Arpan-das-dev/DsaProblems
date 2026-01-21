package BinarySearch;

public class FindMinInRotatedSortedArray {
    public int findMinBrute(int[] nums) {
        int min = nums[0];
        for (int item : nums) min = Math.min(min,item);
        return min;
    }

    //[3,4,5,1,2] n= 5
    // [4,5,6,7,0,1,2] n = 6
    public int findMin(int[] nums) {
       int left = 0;
       int right = nums.length - 1;

       while (left < right) {
           int mid = left + (right - left)/2;

           if(nums[mid]>nums[right]) {
               left = mid+1;
           } else right = mid;
       }
       return nums[left];
    }
}
