package Heaps;

import java.util.PriorityQueue;

public class KClosestPointToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        // sort them by distance -> maxHeap
        PriorityQueue<int[]> distanceQueue = new PriorityQueue<>((a,b)-> b[1]-a[1]);
        // run loop
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0], y = points[i][1];
            // put distance and index as an array representation
            distanceQueue.offer(new int[]{i, x * x + y * y});
            // keep maintain the size of the heap
            if (distanceQueue.size() > k) distanceQueue.poll();
        }
        // final result array of k sized
        int[][] result = new int[k][2];
        int index = 0;
        // populate the array
        while (!distanceQueue.isEmpty()){
            int[] curr = distanceQueue.poll();
            result[index++] = points[curr[0]];
        }
        return result;
    }
}
