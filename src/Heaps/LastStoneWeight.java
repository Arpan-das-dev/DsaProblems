package Heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if(stones == null || stones.length == 0) return 0;
        if(stones.length == 1) return stones[0];

        PriorityQueue<Integer> stoneQueue = new PriorityQueue<>((a, b)-> b-a);
        for (int weights : stones) stoneQueue.offer(weights);

        while (stoneQueue.size() > 1){
            int a = stoneQueue.poll();
            int b = stoneQueue.poll();

            if(a != b) stoneQueue.offer(a-b);
        }
        return stoneQueue.isEmpty() ? 0 : stoneQueue.peek();
    }

    public int lastStoneWeightCollectionVersion(int[] stones) {
        if(stones == null || stones.length == 0) return 0;
        if(stones.length == 1) return stones[0];

        PriorityQueue<Integer> stoneQueue = new PriorityQueue<>(Collections.reverseOrder());
        stoneQueue.addAll(Arrays.stream(stones).boxed().toList());

        while (stoneQueue.size() > 1){
            int a = stoneQueue.poll();
            int b = stoneQueue.poll();

            if(a != b) stoneQueue.offer(a-b);
        }
        return stoneQueue.isEmpty() ? 0 : stoneQueue.peek();
    }
}
