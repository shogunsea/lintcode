class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        // write your code here
        int aLen = A.size();
        int bLen = B.size();
        ArrayList<Integer> res = new ArrayList<Integer>();
        int i = 0, j = 0;
        
        while (i < aLen || j < bLen) {
            if (i == aLen) {
                res.add(B.get(j++));
                continue;
            } else if (j == bLen) {
                res.add(A.get(i++));
                continue;
            }
            
            if (A.get(i) < B.get(j)) {
                res.add(A.get(i++));
            } else {
                res.add(B.get(j++));
            }
        }
        
        return res;
    }
}
