package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> unique = new HashSet<>();
        int left = 0;

        for (int curr : nums) {
            if (unique.contains(curr)) return true;
            else if (unique.size() > k) {
                unique.remove(nums[left]);
                left++;
            } else unique.add(curr);
        }
        return false;
    }
}
