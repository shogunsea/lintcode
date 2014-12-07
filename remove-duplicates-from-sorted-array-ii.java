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
        // two pointers + counter
        int count = 1;
       	int slow = 0;
       	int fast = 1;

       	while (fast < len) {
       		if (nums[fast] == nums[slow]) {
       			if (count < 2) {
       				count++;
       				nums[++slow] = nums[fast];
       			} 
       		} else {
       			nums[++slow] = nums[fast];
       			count = 1;
       		}
       		fast++;
       	}

       	return slow + 1;
    }
}

