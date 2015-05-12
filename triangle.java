public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // write your code here
        if (triangle == null) {
            return 0;
        }
        
        int size = triangle.size();
        ArrayList<Integer> base = triangle.get(size - 1);
        
        for (int i = size - 2; i >= 0; i--) {
            // iterate from last row, accumulate all results onto it.
            int tempSize = triangle.get(i).size();
            for (int j = 0; j < tempSize; j++) {
                int current = triangle.get(i).get(j);
                if (base.get(j) < base.get(j + 1)) {
                    base.set(j, current + base.get(j));
                } else {
                    base.set(j, current + base.get(j + 1));
                }
            }
        }
        
        return base.get(0);
    }
}

