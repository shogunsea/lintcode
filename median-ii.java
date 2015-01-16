public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
            // write your code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(10,
                new Comparator<Integer>(){
                    public int compare(Integer a, Integer b) {
                        return a - b;
                    }
                });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10,
                new Comparator<Integer>(){
                    public int compare(Integer a, Integer b) {
                        return b - a;
                    }
                });

        int len = nums.length;
        int[] res = new int[len];
        res[0] = nums[0];
        minHeap.add(nums[0]);

        for (int i = 1; i < len; i++) {
            // First compare current number with minHeap
            // then add it two min/maxHeap accordingly.
            // Then banlance two heaps so that they only differ
            // by at most one element.
            // Last compare the size and get the median: if same size
            // then median is average of two roots. Otherwise median
            // is the root of longer heap.

            // push to heaps.
            // minHeap: store the bigger value. root(min) value is the smallest
            // element in right half of the array.
            // maxHeap: store smaller values. root(max) value is the largest element
            // in the left half of the array.
            int current = nums[i];
//           {4, 5, 1, 3, 2, 6, 0};
            //  4
            //  5
            if (current < minHeap.peek()) {
                maxHeap.add(current);
            } else {
                minHeap.add(current);
            }

            // balance the heaps.
            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.add(minHeap.poll());
            } else if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }

            int minSize = minHeap.size();
            int maxSize = maxHeap.size();
            if (minSize == maxSize) {
                // based on the median definition, when length is even
                // just return the left middle.
                // otherwise do an average of left and right.
                res[i] = maxHeap.peek();
            } else {
                res[i] = minSize > maxSize? minHeap.peek() : maxHeap.peek();
            }
        }

        return res;
    }
}
