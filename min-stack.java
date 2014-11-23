public class Solution {
    Stack<Integer> nums = null;
    Stack<Integer> mins = null;
    public Solution() {
        // do initialize if necessary
         nums = new Stack<Integer>();
         mins = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        if (nums.isEmpty()) {
            nums.push(number);
            mins.push(number);
        } else {
            nums.push(number);
            int lastMin = mins.peek();
            if (number <= lastMin) {
                mins.push(number);
            }
        }
    }

    public int pop() {
        // write your code here
        int val = nums.pop();
        if (val == mins.peek()) {
            mins.pop();
        }
        return val;
    }

    public int min() {
        // write your code here
        return mins.peek();
    }
}

