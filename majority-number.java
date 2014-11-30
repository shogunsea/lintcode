public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        // quickSelect solution. O(n) time , inplace. O(1) space.
        int size = nums.size();
        if (size == 0) {
            return 0;
        }

        int start = 0;
        int end = size - 1;
        int median = quickSelet(nums, start, end, (start + end) / 2);
        int majority = nums.get(median);
        return majority;
    }

    public int quickSelet(ArrayList<Integer> nums, int start, int end, int n) {

        while (start <= end) {
            int pivot = (start + end) / 2;
            int relocate = partition(nums, start, end, pivot);
            if (relocate == n) {
                return relocate;
            } else if (relocate < n) {
                start = relocate + 1;
            } else {
                end = relocate - 1;
            }
        }

        return - 1;
    }

    public int partition(ArrayList<Integer> nums, int start, int end, int pivot) {
        int pivotal = nums.get(pivot);
        int storedIndex = start;
        swap(nums, end, pivot);

        for (int i = start; i < end; i++) {
            if (nums.get(i) < pivotal) {
                swap(nums, i, storedIndex++);
            }
        }

        swap(nums, end, storedIndex);
        return storedIndex;
    }

    public void swap(ArrayList<Integer> nums, int left, int right) {
        if (nums.get(left) == nums.get(right)) {
            return;
        }
        int temp = nums.get(left);
        nums.set(left, nums.get(right));
        nums.set(right, temp);
    }
}



public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        // hashmap solution. O(n) time, O(n) space.
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (Integer i : nums) {
            map.put(i, map.containsKey(i)? map.get(i) + 1 : 1);
        }
        
        int maxValue = 0;
        int maxKey = 0;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        
        return maxKey;
    }
    
}




public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        // Use Moore's voting algorithm.
        // Time: O(n), space O(1).

        int size = nums.size();
        if (size == 0) {
            return 0;
        }
        // first find candidate.
        int majorIndex = 0;
        int count = 1;
        for (int i = 1; i < size; i++) {
            if (nums.get(majorIndex) == nums.get(i)) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                majorIndex = i;
                count = 1;
            }
        }

        // if solution is not guanranteed to be one,
        // check the count.

        return nums.get(majorIndex);
        
    }
    
}

