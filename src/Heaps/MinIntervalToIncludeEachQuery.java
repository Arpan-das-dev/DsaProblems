package Heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinIntervalToIncludeEachQuery {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // sort the interval by starting
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int [][] qArr = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            qArr[i][0] = queries[i];
            qArr[i][1] = i;
        }
        Arrays.sort(qArr,Comparator.comparingInt(a-> a[0]));

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int [] result = new int[queries.length];
        Arrays.fill(result,-1);

        int index = 0;

        for (int [] qr : qArr){
            int query = qr[0];
            int idx = qr[1];

            while (index < intervals.length && intervals[index][0] <= query) {
                int start = intervals[index][0];
                int end = intervals[index][1];
                int length = end-start+1;
                queue.offer(new int[] {length,end});
                index++;
            }

            // remove element
            while (!queue.isEmpty() && queue.peek()[1] < query) queue.poll();
            if(!queue.isEmpty()){
                result[idx] = queue.peek()[0];
            }
        }
        return result;
    }
}
