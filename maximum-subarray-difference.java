public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
        // write your code
        if (nums == null) {
            return 0;
        }
        
        //    -4, -5
        //min:-4, -9
        //max:-4, -5
        //  1
  //        -4， 3， -2， 6
  // -->min:-4, -4, -6,  -6
  //         7   7   6   6 <--max:

        // the whole idea is that we want to figure out
        // max difference between two non-overlapping subarray
        // the problem can be transformed into:
        // for each index i in [0, n]
        // we want to know maximal subarray sum in [0, i] and minimal
        // subarray sum in (i, n] , notice the inclusive and exclusive
        // interval. Then do the substraction. Also we want to the 
        // reverse order case: for each index i, minimal subarray in
        // [0, i] and maximal in (i, n]. In theory we need to preprocess the
        // input array twice to get 4 such arrays.

    //     1, 2, -3, 1
    // min:1  1  -3  -3
    // max:3  2   1   1

    // min:-3 -3  -3  1        
    // max: 1  3   3  3
        int size = nums.size();
        int[] minInorder = new int[size];
        int[] maxReverse = new int[size];
        int[] maxInorder = new int[size];
        int[] minReverse = new int[size];

        // fill two inorder array.
        int preMin = nums.get(0);
        int preMax = preMin;
        int min = preMin;
        int max = preMax;   
        minInorder[0] = min;
        maxInorder[0] = max;

        for (int i = 1; i < size; i++) {
            int current = nums.get(i);
            preMin = Math.min(preMin + current, current);
            preMax  = Math.max(preMax + current, current);
            min = min > preMin? preMin : min;
            max = max < preMax? preMax : max;
            minInorder[i] = min;
            maxInorder[i] = max;
        }

        preMin = nums.get(size - 1);
        preMax = preMin;
        minReverse[size - 2] = preMin;
        maxReverse[size - 2] = preMax;
        min = preMin;
        max = preMax;

        for (int i = size - 3; i >= 0; i--) {
            int current = nums.get(i + 1);
            preMin = Math.min(preMin + current, current);
            preMax  = Math.max(preMax + current, current);
            min = min > preMin? preMin : min;
            max = max < preMax? preMax : max;
            minReverse[i] = min;
            maxReverse[i] = max;
        }

        int maxDiff = 0;

        for (int i = 0; i < size - 1; i++) {
            int minMax = maxReverse[i] - minInorder[i];
            int maxMin = maxInorder[i] - minReverse[i];
            int update = minMax > maxMin? minMax : maxMin;
            maxDiff = maxDiff < update? update : maxDiff;
        }

        return maxDiff;
    }
}


