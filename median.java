public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        // quick select mid-th element.
        int medianIndex = (len % 2 == 0)? len / 2 - 1 : len / 2;
        int start = 0;
        int end = len - 1;
        
        //
        while (start <= end) {
            int mid = (start + end) / 2;
            int relocate = partition(nums, start, end, mid);
            if (medianIndex == relocate) {
                return nums[medianIndex];
            } else if (relocate > medianIndex) {
                end = relocate - 1;
            } else {
                start = relocate + 1;
            }
        }
        
        return 0;
    }
    
    public int partition(int[] nums, int start, int end, int pivot) {
        // return the right index of pivotal
        int pivotal = nums[pivot];
        swap(nums, end, pivot);
        int storedIndex = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivotal) {
                swap(nums, i, storedIndex++);
                // 4 9 8 5 1 6 3 : pivotal is 5
                // 4 9 8 3 1 6 5
                // dot denotes the value of storedIndex.
                // 4 .
                // 4 9.
                // 4 9. 8
                // 4 3 8. 9
                // 4 3 1 9. 8
                // 4 3 1 9. 8 6
                // 4 3 1 9. 8 6 5
                // 4 3 1 5. 8 6 9
            } 
        }
        
        swap(nums, storedIndex, end);
        return storedIndex;
    }
    
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

