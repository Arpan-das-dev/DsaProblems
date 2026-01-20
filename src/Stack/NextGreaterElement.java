package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement {
    //[4,1,2], nums2 = [1,3,4,2]
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Deque<Integer> integerDeque = new ArrayDeque<>();

        for (int item : nums2) {
            while (!integerDeque.isEmpty() && integerDeque.peek() < item) {
                map.put(integerDeque.pop(),item);
            }
            integerDeque.push(item);
        }

        int [] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i],-1);
        }
        return result;
    }
}
