import java.util.Collections;
class Solution {
    //param k : description of k
    //param numbers : array of numbers
    //return: description of return
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        // write your code here
        int kth = quickSelect(numbers, k - 1);
        return kth;
    }
    
    public int quickSelect(ArrayList<Integer> nums, int n) {
        int start = 0;
        int end = nums.size() - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            int relocate = partition(nums, start, end, mid);
            if (relocate == n) {
                return nums.get(n);
            } else if (relocate < n) {
                start = relocate + 1;
            } else {
                end = relocate - 1;
            }
        }
        
        return -1;
    }
    
    public int partition(ArrayList<Integer> nums, int start, int end, int pivot) {
        int pivotal = nums.get(pivot);
        swap(nums, end, pivot);
        int storedIndex = start;
        for (int i = start; i < end; i++) {
            if (nums.get(i) > pivotal) {
                swap(nums, i, storedIndex++);
            }
        }
        swap(nums, storedIndex, end);
        return storedIndex;
    }
    
    public void swap(ArrayList<Integer> nums, int a, int b) {
        if (nums.get(a) != nums.get(b)) {
            int temp = nums.get(a);
            nums.set(a, nums.get(b));
            nums.set(b, temp);
        }
    }
};
