import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {     
        //write your code here
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tempList = new ArrayList<Integer>();

        for (int i = 0; i < num.length; i++) {
        	if (i != 0 && num[i] == num[i - 1]) {
        		continue;
        	}
        	for (int j = i + 1; j < num.length; j++) {
        		if (j != i + 1 && num[j] == num[j - 1]) {
        			continue;
        		}
        		int left = j + 1;
        		int right = num.length - 1;

        		while (left < right) {
        			int sum = num[i] + num[j] + num[left] + num[right];

        			if (sum == target) {
        				tempList.add(num[i]);
        				tempList.add(num[j]);
        				tempList.add(num[left]);
        				tempList.add(num[right]);
        				res.add(new ArrayList<Integer>(tempList));
        				tempList = new ArrayList<Integer>();
        				left++;
        				right--;
        				while (left < right && num[left] == num[left - 1] && num[right] == num[right + 1]) {
        					left++;
        					right--;
        				}
        			} else if (sum < target) {
        				left++;
        				while (left < right && num[left] == num[left - 1]) {
        					left++;
        				}
        			} else {
        				right--;
        				while (left < right && num[right] == num[right + 1]) {
        					right--;
        				}
        			}
        		}
        	}
        }

        return res;
    }
}
