public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
	// Solution One: sum the bits from all 
	// elements then mod by 3.
    public int singleNumberII(int[] A) {
    	int len = A.length;
    	if (len == 0) {
    		return len;
    	}

    	int res = 0;

    	for (int i = 0; i < 32; i++) {
    		// check i-th bit on all elements.
    		int temp = 0;
    		for (int j = 0; j < len; j++) {
    			int num = A[j];
    			// check if i-th bit is one or not.
    			temp += ((num >> i) & 1);
    		}

    		// temp is the sum, mod by 3 and set
    		// it on the right bit.
    		res = res | ((temp % 3) << i);
    	}

    	return res;
    }

    // Solution two: use three variables to mock the
    // behavior of ternary operation.
    public int singleNumberII(int[] A) {
    	int ones = 0;
    	int twos = 0;
    	int threes = 0;
    	for (int i : A) {
    		// why update twos first here:
    		// XOR operation will lose the bits info of carry.
    		// First compute the carry bits, since we use twos
    		// to indentify this, we dont have to left shit
    		// the carry bits.
    		twos = twos | ones & i;
    		ones = ones ^ i;
    		threes = (ones & twos);
    		ones = ones & (~threes);
    		twos = twos & (~threes);
    	}

    	return ones;
    }
}


