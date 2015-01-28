public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int len = A.length;
        if (len == 0) {
            return res;
        }
        
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        for (int i = 0; i < len; i++) {
            tempList.add(A[i]);
            dfsHelper(A, res, tempList, target, i, k, A[i]);
            tempList.remove(0);
        }
        
        return res;
    }
    
    public void dfsHelper(int[] A, ArrayList<ArrayList<Integer>> res, ArrayList<Integer>
        tempList, int target, int index, int k, int curSum) {
            if (tempList.size() == k) {
                if (curSum == target) {
                    res.add(new ArrayList<Integer>(tempList));
                }
                return;
            }
            
            for (int i = index + 1; i < A.length; i++) {
                tempList.add(A[i]);
                curSum += A[i];
                dfsHelper(A, res, tempList, target, i, k, curSum);
                curSum -= A[i];
                tempList.remove(tempList.size() - 1);
            }
        }
}

