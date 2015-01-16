public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        // split the original string and sort.
        // note the usage of Map.Entry
        List<String> res = new ArrayList<String>();
        Map<String, List<String>> dict = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ss = s.toCharArray();
            Arrays.sort(ss);
            String tempString = new String(ss);
            if (!dict.containsKey(tempString)) {
                dict.put(tempString, new ArrayList<String>());
            }
            dict.get(tempString).add(s);
        }
        for (Map.Entry<String, List<String>> entry : dict.entrySet()) {
            if (entry.getValue().size() > 1) {
                res.addAll(entry.getValue());
            }
        }
        
        return res;
    }
}
