import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        // write your code here
        Arrays.sort(numbers);
        int sum = 0;
        int err = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {
        	int left = i + 1;
        	int right = numbers.length - 1;

        	while (left < right) {
        		int tempSum = numbers[i] + numbers[left] + numbers[right];
        		int tempErr = Math.abs(target - tempSum);
        		if (tempErr == 0) {
        			return tempSum;
        		} else if (tempErr < err) {
        			err = tempErr;
        			sum = tempSum;
        		}

        		if (tempSum > target) {
        			right--;
        		} else {
        			left++;
        		}
        	}
        }

        return sum;
    }
}

