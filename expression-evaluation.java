// Given an expression string array, return the final result of this expression

// Example
// For the expression 2*6-(23+7)/(1+2), input is

// [
//   "2", "*", "6", "-", "(",
//   "23", "+", "7", ")", "/",
//   (", "1", "+", "2", ")"
// ],
// return 2

// Note
// The expression contains only integer, +, -, *, /, (, ).

public class Solution {
    /**
     * @param expression: an array of strings;
     * @return: an integer
     */
    public int evaluateExpression(String[] exp) {
        int len = exp.length;
        if (len == 0) {
            return 0;
        }

        Stack<Integer> vals = new Stack<Integer>();
        int[] index = {0};

        return helper(exp, index, vals);

    }

    public int helper(String[] exp, int[] index, Stack<Integer> vals) {
        if (index[0] == exp.length) {
            return 0;
        }
        Stack<String> operators = new Stack<String>();
        // alwasy start from 1st element after "("
        int i = index[0];
        for (; i < exp.length; i++) {
            if (exp[i].equals(")")) {
                // done with current recursion
                break;
            } else if (isOp(exp[i])) {
                operators.push(exp[i]);
            } else {
                int val = 0;
                if (exp[i].equals("(")){
                    int[] tmp = {i + 1};
                    val = helper(exp, tmp, vals);
                    i = tmp[0];
                } else {
                    val = Integer.parseInt(exp[i]);
                }

                if (!operators.isEmpty() && (operators.peek().equals("*") || operators.peek().equals("/"))) {
                    int right = val;
                    int left = vals.pop();
                    String op = operators.pop();
                    int res = compute(left, op, right);
                    vals.push(res);
                } else {
                    // treat "-" as sign rather than operator, since "-" operator is buggy and hard to handle.
                    if (!operators.isEmpty() && operators.peek().equals("-")) {
                        val = -val;
                    }
                    vals.push(val);
                }
            }  
        }

        // sum all remaining values
        while(!operators.isEmpty()) {
            int right = vals.pop();
            int left = vals.pop();
            operators.pop();
            // int res = compute(left, "+", right);
            vals.push(left + right);
        }

        index[0] = i;

        return vals.isEmpty()? 0 : vals.pop();
    }

    public boolean isOp(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public int compute(int left, String op, int right) {
        if (op.equals("+")) {
            return left + right;
        } else if (op.equals("-")) {
            return left - right;
        } else if (op.equals("*")) {
            return left * right;
        } else {
            return left / right;
        }
    }
};
