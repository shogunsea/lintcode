public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        // the idea is that:
        // two numbers that appear onece must differ in certain
        // bit x. The XOR of all elements will represent
        // this difference, thus we can group original
        // input into two groups based on first bit that is 1.
        // Then do the XOR on each group is the single element.
        int len = A.length;
        List<Integer> res = new ArrayList<Integer>();
        if (len == 0) { 
        	return res;
        }

        int xor = 0;

        for (int i : A) {
        	xor ^= i;
        }

        int oneBit = 1;
        for (int i = 0; i < 32; i++) {
            oneBit = 1 << i;
        	if ((xor & oneBit) != 0) {
        		oneBit = i;
        		break;
        	} 
        }

        int ones = 0;
        int zeros = 0;
        for (int i : A) {
        	if (((i >> oneBit) & 1) == 1) {
        		ones ^= i;
        	} else {
        		zeros ^= i;
        	}
        }

       res.add(ones);
       res.add(zeros);

        return res;

    }
}
