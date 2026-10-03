import java.util.*;

class MedianFinder {

    PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();

    public MedianFinder() {}

    public void addNum(int num) {
        if (leftMaxHeap.isEmpty() || num <= leftMaxHeap.peek()) {
            leftMaxHeap.add(num);
        } else {
            rightMinHeap.add(num);
        }

        // rebalance: left should have equal size, or exactly 1 more
        if (leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.add(rightMinHeap.poll());
        } else if (leftMaxHeap.size() - rightMinHeap.size() > 1) {
            rightMinHeap.add(leftMaxHeap.poll());
        }
    }

    public double findMedian() {
        if (leftMaxHeap.size() == rightMinHeap.size()) {
            return ((double) leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
        }
        return leftMaxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */