class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        int len = S.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (len == 0) {
            return res;
        }
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        Collections.sort(S);
        for (int i = 0; i <= len; i++) {
            searchHelper(S, res, tempList, i, 0);
        }
        
        return res;
    }
    
    public void searchHelper(ArrayList<Integer> num, ArrayList<ArrayList<Integer>> res,
        ArrayList<Integer> tempList, int len, int index) {
            if (tempList.size() == len) {
                res.add(new ArrayList<Integer>(tempList));
                return;
            }
            
            for (int i = index; i < num.size(); i++) {
                if (i != index && num.get(i) == num.get(i - 1)) continue;
                tempList.add(num.get(i));
                searchHelper(num, res, tempList, len, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
}

