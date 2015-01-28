public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    // 9/18 cases passed, wrong solution.
    public int largestRectangleArea2(int[] height) {
        // write your code here
        int len = height.length;
        if (len == 0) {
        	return 0;
        }

        int maxArea = 0;

        for (int i = 0; i < len; i++) {
        	for (int j = i; j < len; j++) {
        		int minHeight = Math.min(height[i], height[j]);
        		// ensure all elements between i, j are at most minHeight
        		if (!isUnderMin(height, i, j, minHeight)) {
        			continue;
        		}
        		maxArea = Math.max(maxArea, minHeight * (j - i + 1));
        	}
        }
        return maxArea;
    }

    public boolean isUnderMin(int[] h, int start, int end, int min) {
    	for (int i = start; i <= end; i++) {
    		if (h[i] < min || h[i] == 0) {
    			return false;
    		}
    	}
    	return true;
    }

    // Correct O(n2) solution, 12/18 cases passed, TLE.
    public int largestRectangleArea3(int[] height) {
    	int len = height.length;
        if (len == 0) {
        	return 0;
        }

        int maxArea = 0;
        // expand to two sides.
        for (int i = 0; i < len; i++) {
        	int min = height[i];
        	int right = i;
        	while (right + 1 < len && height[right + 1] >= min) {
        		right++;
        	}
        	int left = i;
        	while (left - 1 >= 0 && height[left - 1] >= min) {
        		left--;
        	}
        	maxArea = Math.max(maxArea, min * (right - left + 1));
        }

        return maxArea;

    }

    // Correct version. O(n) time.
    // Idea: Iterate over elements, if stack is empty(initial state),
    // just push the element onto stack, otherwise compare current 
    // element with top element on stack, if its increasing, push current element onto stack and increse runner index i, so that all indexes in the stack are increasing even though there could be gaps between them. If current element if decreasing from stack top element, we start to compute the area.
    // The correctness for doing this:
    // At some point when decreasing pattern found, we have runner index i, current element index is poped from the stack and we name it as 'current', there are three interested indexes: i, current, st.peek(). 'current' index represent the element which we are computing as the height, we want to expand the index to right(i - current) and left (current - st.peek()) to get the width.

    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int len = height.length;
        if (len == 0) {
            return 0;
        }
        int i = 0;
        int maxArea = 0;
        while (i <= len) {
            int cur = i == len? 0 : height[i];
            if (stack.isEmpty() || height[stack.peek()] <= cur) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, height[t] * (
                    stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }

}


























