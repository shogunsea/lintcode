public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        
        int slow = 0;
        int fast = 1;
        
        while (fast < len) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast++];
            }else {
                fast++;
            }
        }
        
        return slow + 1;
    }
}
