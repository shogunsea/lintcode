public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(ArrayList<Integer> nums) {
        // write your code
        // brute force O(n^2)
        if (nums == null) {
            return 0;
        }
        
        int max = nums.get(0);
        int size = nums.size();
        
        for (int i = 0; i < size; i++) {
            int tempSum = nums.get(i);
            max = max < tempSum? tempSum : max;
            for (int j = i + 1; j < size; j++) {
                if (tempSum > 0) {
                    tempSum += nums.get(j);   
                    max = max < tempSum? tempSum : max;
                } else {
                    break;
                }
                
            }
            
            
        }
        
        return max;
    }
}


// O(n) solution.
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null) {
            return 0;
        }
        
        int max = nums.get(0);
        int previousSum = max;
        int size = nums.size();
        // as long as previous sum is positive, it can
        // contribute to following subarray. however
        // negative values in the folloing subarry 
        // might decrease the totalsum, so we need to 
        // update the global sum with possible
        // maximal sum.
    
        for (int i = 1; i < size; i++) {
            int current = nums.get(i);
            previousSum = Math.max(current, current + previousSum);
            max = max < previousSum? previousSum : max;
        }
        
        return max;
    }
}
