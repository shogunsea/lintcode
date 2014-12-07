public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: The recovered sorted array
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        // three steps rotation
        int index = -1;
        int size = nums.size();
        if (size == 0) {
            return;
        }
        for (int i = 1; i < size; i++) {
            if (nums.get(i) <  nums.get(i - 1)) {
                index = i - 1;
                break;
            }
        }
        
        if (index == -1) {
            return;
        }
        
        reverse(nums, 0, index);
        reverse(nums, index + 1, size -1);
        reverse(nums, 0, size - 1);
        
    }
    
    public void reverse(ArrayList<Integer> nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
    
    public void swap(ArrayList<Integer> nums, int a, int b) {
        int temp = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, temp);
    }
}
