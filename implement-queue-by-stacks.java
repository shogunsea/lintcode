public class Solution {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Solution() {
       // do initialization if necessary
       // push stack
       stack1 = new Stack<Integer>();
       // pop stack
       stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            this.populate();
            return stack2.pop();
        }
    }
    
    private void populate() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public int top() {
        // write your code here
        if (!stack2.isEmpty()) {
            return stack2.peek();
        } else {
            this.populate();
            return stack2.peek();
        }
    }
}

