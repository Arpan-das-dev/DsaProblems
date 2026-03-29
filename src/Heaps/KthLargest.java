package Heaps;

import java.util.PriorityQueue;

public class KthLargest {
    private final int k;
    private final PriorityQueue<Integer> stream;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.stream = new PriorityQueue<>();
        for (int val: nums) add(val);
    }

    public int add(int val) {
        stream.offer(val);

        if(stream.size() > k){
            stream.poll();
        }
        return stream.isEmpty() ? 0: stream.peek();
    }
}
