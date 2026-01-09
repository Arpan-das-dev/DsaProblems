package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> lists = new ArrayList<>();

        Arrays.sort(num);
        int n = num.length;

        for (int i = 0; i < n-2; i++) {
            if(i>0 && num[i] == num[i-1]) continue;

            int left = i+1;
            int right = n-1;
            while (left<right) {
                int sum = num[i] + num[left] + num[right];
                if(sum==0) {
                    lists.add(List.of(num[i],num[left],num[right]));
                    while (left<right && num[left] == num[left+1]) left ++;
                    while (left<right && num[right] == num[right-1]) right --;

                    left++;
                    right --;
                } else if (sum<0) {
                    left ++;
                } else {
                    right --;
                }
            }

        }
        return lists;
    }
}
