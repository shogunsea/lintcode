public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        // same integer can be picked unlimited number of times.
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (len == 0) {
        	return res;
        }

        Arrays.sort(candidates);

        List<Integer> tempList = new ArrayList<Integer>();

        dfsHelper(res, tempList, candidates, target, 0, 0);

        return res;
    }

    public void dfsHelper(List<List<Integer>> res, List<Integer> tempList, int[] nums, int target, int index, int sum) {
    	if (sum == target) {
    		res.add(new ArrayList<Integer>(tempList));
    		return;
    	} else if (index == nums.length || sum > target) {
    		return;
    	}

    	for (int i = index; i < nums.length; i++) {
    		int n = nums[i];
    		tempList.add(n);
    		dfsHelper(res, tempList, nums, target, i, sum + n);
    		tempList.remove(tempList.size() - 1);
    	}
    }
}
