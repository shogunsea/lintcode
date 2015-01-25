/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode runner = root;
        
        while (runner != null || !st.isEmpty()) {
            if (runner != null) {
                st.push(runner);
                runner = runner.left;
            } else {
                runner = st.pop();
                if (runner.val >= k1 && runner.val <= k2) {
                    res.add(runner.val);
                }
                runner = runner.right;
            }
        }
        
        return res;
    }
}
