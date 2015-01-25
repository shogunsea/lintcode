public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        int len = num.length;
        if (len == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i : num) {
            set.add(i);
        }
        
        int maxLen = -1;
        for (int i : num) {
            int tempLen = 1;
            int bigger = i + 1;
            while (set.contains(bigger)) {
                tempLen++;
                set.remove(bigger++);
            }
            int smaller = i - 1;
            while (set.contains(smaller)) {
                tempLen++;
                set.remove(smaller--);
            }
            set.remove(i);
            maxLen = maxLen < tempLen? tempLen : maxLen;
        }
        return maxLen;
    }
}
