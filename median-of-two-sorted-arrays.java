class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int aLen = A.length;
    	int bLen = B.length;
    	int len = aLen +bLen;

    	if ((len & 1) == 1) {
    		// odd
    		return findKth(A, 0, B, 0, len / 2 + 1);
    	} else {
    		// even
    		double left = findKth(A, 0, B, 0, len / 2);
    		double right = findKth(A, 0, B, 0, len / 2 + 1);
    		return (left + right) / 2;
    	}
    }

    public double findKth(int[] A, int aStart, int[] B, int bStart, int k) {
    	if (aStart > A.length - 1) {
    		return B[bStart + k - 1];
    	} else if (bStart > B.length - 1) {
    		return A[aStart + k - 1];
    	} else if (k == 1) {
    		return Math.min(A[aStart], B[bStart]);
    	}

    	int aHalf = aStart + k / 2 - 1 > A.length - 1? Integer.MAX_VALUE : A[aStart + k / 2 - 1];
    	int bHalf = bStart + k / 2 - 1 > B.length - 1? Integer.MAX_VALUE : B[bStart + k / 2 - 1];

    	if (aHalf < bHalf) {
    		// drop k / 2 elements from A.
    		return findKth(A, aStart + k / 2, B, bStart, k - k / 2);
    	} else {
    		// drop k / 2 elements from B.
    		return findKth(A, aStart, B, bStart + k /2, k - k / 2);
    	}
    }
}

