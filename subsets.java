class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
            // write your code here
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            if (S == null) {
                return res;
            }

            int size = S.size();

            Collections.sort(S);
            ArrayList<Integer> tempList = new ArrayList<Integer>();

            for (int i = 0; i <= size; i++) {
                dfsHelper(res, i, S, tempList, 0);
            }

            return res;
        }

        public void dfsHelper(ArrayList<ArrayList<Integer>> res, int len, ArrayList<Integer> nums, ArrayList<Integer> tempList,
                              int index) {
            if (tempList.size() == len) {
                res.add(new ArrayList<Integer>(tempList));
                return;
            } else if (index == nums.size()) {
                return;
            }

            for (int i = index; i < nums.size(); i++) {
                int n = nums.get(i);
                tempList.add(n);
                dfsHelper(res, len, nums, tempList, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
}
