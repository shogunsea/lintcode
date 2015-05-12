class Solution {
    /**
     * Returns a index to the first occurrence of target in source, or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        if (source == null || target == null) {
            return -1;
        }
        int sLen = source.length();
        int tLen = target.length();
        if (sLen == 0) {
            return tLen == 0? 0 : -1;
        } else if (tLen == 0) {
            return 0;
        } else if (sLen < tLen) {
            return - 1;
        }

        for (int i = 0; i < sLen - tLen; i++) {
            if (source.charAt(i) == target.charAt(0)) {
                int j = 0;
                for (; j < tLen; j++) {
                    if (target.charAt(j) == source.charAt(i + j)) {
                        continue;
                    } else {
                        break;
                    }
                }
                if (j == tLen) {
                    return  i;
                }
            }
        }


        return -1;
    }
}
