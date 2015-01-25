public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (n <= 0 || k == 0) {
		    return res;
		}
		
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
		    nums[i] = i + 1;
		}
		
		List<Integer> tempList = new ArrayList<Integer>();
		
		// 1 2 3 4
		for (int i = 0; i <= n - k; i++) {
		    tempList.add(nums[i]);
		    helper(res, tempList, nums, k, i + 1);
            tempList.remove(tempList.size() - 1);
		}
		
		return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> tempList, int[] nums,
        int len, int index) {
            if (tempList.size() == len) {
                // valid match.
                res.add(new ArrayList<Integer>(tempList));
                return;
            }
            
            if (index == nums.length) {
                return;
            }
            
            for (int i = index; i < nums.length; i++) {
                tempList.add(nums[i]);
                helper(res, tempList, nums, len, i + 1);
                tempList.remove(tempList.size() - 1);
            }
    }
}
