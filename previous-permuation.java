public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		// write your code
		// Exact reverse problem of 'next permutation'
		// Find first increasing indexes, swap, then reverse the rest?
		//   1342523
		//   1342352
		if (nums == null) {
		    return nums;
		}
		int size = nums.size();
		int left = size - 2;
		boolean increase = false;
		
		while (left >= 0) {
		    for (int i = left + 1; i < size; i++) {
		        if (nums.get(left) > nums.get(i)) {
		            increase = true;
		            break;
		        }
		    }
		    if (increase) {
		        break;
		    }
		    left--;
		}
		
		if (left == -1) {
		    // no valid increase sequence.
		    reverse(nums, 0, size - 1);
		    return nums;
		}
		
		int right = 0;
        for (int i = left + 1; i < size; i++) {
            if (nums.get(i) < nums.get(left)) {
                right = i;
            }
        }		
        
        swap(nums, left, right);
        reverse(nums, left + 1, size - 1);
        
        return nums;
    }
    
    public void reverse(ArrayList<Integer> nums, int start, int end) {
        while (start <= end) {
            swap(nums, start++, end--);
        }
    }
    
    public void swap(ArrayList<Integer> nums, int a, int b) {
        int temp = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, temp);
    }
}

