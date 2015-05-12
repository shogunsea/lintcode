public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int first = -1;
        int second = -1;
        boolean found = false;
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = numbers.length - 1; j > i; j--) {
                if (numbers[i] + numbers[j] == target) {
                    first = i + 1;
                    second = j + 1;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        
        int[] res = {first, second};
        return res;
    }
}
