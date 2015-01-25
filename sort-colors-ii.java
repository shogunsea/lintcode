class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        int len = colors.length;
        if (len == 0) {
            return;
        }
        int kIndex = 0;
        int count = 1;
        while (count != k) {
            // loop k times.
            int runner = kIndex;
            
            while (runner < len) {
                if (colors[runner] == count) {
                    swap(colors, runner, kIndex++);
                }
                runner++;
            }
            count++;

        }
    }
    
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
