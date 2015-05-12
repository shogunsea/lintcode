public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        int len = A.length();
        if (len == k) {
            return "";
        }
        int idx = 0;
        int[] num = new int[len];
        for (int i = 0; i < len; i++) {
            num[i] = A.charAt(i) - '0';
        }

        while (k > 0) {
            // if current number is greater than
            // next number: decreasing seq. drop
            // first digit.
            if (num[idx] > num[idx + 1]) {
                num[idx] = -1;
                k--;
            } else {
                while (idx + 1 < num.length && num[idx] <= num[idx + 1]) {
                    // keep increasing idx if pre
                    // seq is increasing
                    idx++;
                }
                // current idx is a violation
                num[idx] = -1;
                k--;
                idx = 0;
                num = refresh(num);
            }
        }
        while (num.length > 0 && num[0] == 0) {
            num[0] = -1;
            num = refresh(num);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : num) {
            sb.append(i + "");
        }

        return sb.toString();

    }

    public int[] refresh(int[] num) {
        int count = 0;
        for (int i : num) {
            if (i >= 0) {
                count++;
            }
        }
        int[] res = new int[count];
        int i = 0;
        for (int j = 0; j < num.length; j++) {
            if (num[j] >= 0) {
                res[i++] = num[j];
            }
        }

        return res;
    }
}
