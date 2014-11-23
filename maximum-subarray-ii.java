public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        // maxInorder, maxReverse
        int size = nums.size();
        int[] maxInorder = new int[size];
        int[] maxReverse = new int[size];
        
        int preMax = nums.get(0);
        int max = preMax;
        maxInorder[0] = preMax;
        
        for (int i = 1; i < size; i++) {
            int current = nums.get(i);
            preMax = Math.max(preMax + current, current);
            max = max < preMax? preMax : max;
            maxInorder[i] = max;
        }
        
        preMax = nums.get(size - 1);
        maxReverse[size - 2] = preMax;
        max = preMax;
        
        for (int i = size - 3; i >= 0; i--) {
            int current = nums.get(i + 1);
            preMax = Math.max(preMax + current, current);
            max = max < preMax? preMax : max;
            maxReverse[i] = max;
        }
        
        int maxSum = maxInorder[0] + maxReverse[0];
        
        for (int i = 0; i < size - 1; i++) {
            int tempSum = maxInorder[i] + maxReverse[i];
            maxSum = maxSum < tempSum? tempSum : maxSum;
        }
        
        return maxSum;
    }
}


