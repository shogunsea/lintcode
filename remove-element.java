public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        int len = A.length;
        if (len == 0) {
        	return len;
        }

        int slow = 0;
        int fast = 0;
        while (fast != len) {
        	if (A[fast] == elem) {
        		fast++;
        	} else {
        		A[slow++] = A[fast++];
        	}
        }

        return slow;
    }
}

