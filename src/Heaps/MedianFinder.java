package Heaps;

import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>((a,b)-> b -a);
        this.minHeap = new PriorityQueue<>((a,b)-> a -b);
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.offer(num);
        } else minHeap.offer(num);

        if(maxHeap.size() > minHeap.size()+1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size() == minHeap.size()) return (double) (maxHeap.peek() + minHeap.peek()) /2;
        return maxHeap.peek();
    }
}
