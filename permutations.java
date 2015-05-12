class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
        	return res;
        }
        int size = nums.size();


        boolean[] used = new boolean[size];
        ArrayList<Integer> tempList = new ArrayList<Integer>();

        for (int i = 0; i < size; i++) {
        	used[i] = true;
        	tempList.add(nums.get(i));
        	dfsHelper(res, nums, used, tempList);
        	tempList.remove(tempList.size() - 1);
        	used[i] = false;
        }

        return res;
    }

    public void dfsHelper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> nums, boolean[] used, ArrayList<Integer> tempList) {
    	if (tempList.size() == nums.size()) {
    		// valid permutation.
    		res.add(new ArrayList<Integer>(tempList));
    		return;
    	}

    	for (int i = 0; i < nums.size(); i++) {
    		if (used[i]) {
    			continue;
    		}

    		used[i] = true;
    		tempList.add(nums.get(i));
    		dfsHelper(res, nums, used, tempList);
    		used[i] = false;
    		tempList.remove(tempList.size() - 1);
    	}
    }
}

