package BitManipulation;

import java.util.*;

public class SortByNumberOfBits {
    public int[] sortByBits(int[] arr) {
        if(arr == null || arr.length == 0) return new int[] {};
        if(arr.length == 1) return arr;
        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
        Arrays.sort(nums,(a,b)-> {
            int c = Integer.bitCount(a) - Integer.bitCount(b);
            return c != 0 ? c : a-b;
        });
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        return arr;
    }
}
