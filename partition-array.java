public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(ArrayList<Integer> nums, int k) {
	    //write your code here
	    int size = nums.size();
	    if (size == 0) {
	        return 0;
	    }
	    
	    int start = 0;
	    int end = size - 1;
	    
	    while (start <= end) {
	        while (start <= end && nums.get(start) < k) {
	            start++;
	        }
	        while (start <= end && nums.get(end) >= k) {
	            end--;
	        }
	        
	        if (start <= end) {
	            swap(nums, start, end);
    	        start++;
    	        end--;
	        }
	    }
	    return start;
    }
    
    public void swap(ArrayList<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}
