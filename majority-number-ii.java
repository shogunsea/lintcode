public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (Integer i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
            
            if (map.size() == 3) {
                removeKey(map);
            }
        }
        int maxKey = 0;
        int max = 0;
        for (int i : map.keySet()) {
            int count = 0;
            for (Integer j : nums) {
                if (i == j) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
                maxKey = i;
            }
        }
        return maxKey;
    }
    
    
    private void removeKey(Map<Integer, Integer> map) {
        Set<Integer> keySet = map.keySet();
        List<Integer> removeList = new ArrayList<>();
        for (Integer key : keySet) {
            map.put(key, map.get(key) - 1);
            if (map.get(key) == 0) {
                removeList.add(key);
            }
        }
        for (int key : removeList) {
            map.remove(key);
        }
    }
}

