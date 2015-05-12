import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        Arrays.sort(numbers);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        
        for (int i = 0; i < numbers.length; i++) {
            if ( i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = numbers.length - 1;
            
            while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                if (sum == 0) {
                    tempList.add(numbers[i]);
                    tempList.add(numbers[left]);
                    tempList.add(numbers[right]);
                    res.add(tempList);
                    tempList = new ArrayList<Integer>();
                    left++;
                    right--;
                    while (left < right && numbers[left] == numbers[left - 1] && numbers[right] == numbers[right + 1]) {
                        left++;
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                    while (left < right && numbers[left] == numbers[left - 1]) {
                        left++;
                    }
                } else {
                    right--;
                    while (left < right && numbers[right] == numbers[right + 1]) {
                        right--;
                    }
                }
            }
        }
        
        return res;
    }
}
