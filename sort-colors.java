class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        int len = nums.length;
        if (len == 0) {
            return;
        }
        
        int zeroIndex = 0;
        int twoIndex = len - 1;
        int i = 0;
        
        while (i != twoIndex) {
            if (nums[i] == 0) {
                swap(nums, i, zeroIndex++);
            } else if (nums[i] == 2) {
                swap(nums, i--, twoIndex--);
            } else {
                // do nothing
            }
            
            i++;
        }
        
        if (nums[i] == 0) {
            swap(nums, i, zeroIndex);
        }
        
    }
    
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
