public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        for (int i = 1; i < A.length; i++) {
            minHeapify(A, i);
        }
    }
    
    public void minHeapify(int[] A, int index) {
        if (hasParent(index)) {
            int p = getParent(index);
            if (A[index] < A[p]) {
                swap(A, p, index);
                minHeapify(A, p);
            }
        }
    }
    
    public boolean hasParent(int index) {
        if ((index - 1) / 2 >= 0) {
            return true;
        } 
        return false;
    }
    
    public int getParent(int index) {
        return (index - 1) / 2;
    }
    
    public void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
