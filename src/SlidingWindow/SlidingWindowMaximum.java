package SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>(nums.length-k+1);
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i =0; i< nums.length; i++){
            // validate size of the size of the dequeue with the window size
            if(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst(); // poll the first element from the queue
            }

            // now store only top values at the top
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                // pop least value from the queue
                dq.pollLast();
            }

            // now offer the current index
            dq.offerLast(i);

            // if i >= k-1 i.e a valid subarray of k size window we now add top element
            // in the result because it;s the max
            if(i >= k-1){
                result.add(nums[dq.getFirst()]);
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}
