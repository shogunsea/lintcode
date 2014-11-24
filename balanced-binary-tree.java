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
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return balanceHelper(root) != -1;
    }
    
    public int balanceHelper(TreeNode node) {
        // return -1 to indicate unbalanced, other wise return
        // the height.
        if (node == null) {
            return 0;
        }
        
        int left = balanceHelper(node.left);
        if (left == -1) {
            return -1;
        }
        
        int right = balanceHelper(node.right);
        if (right == -1) {
            return -1;
        }
        
        int diff = Math.abs(left - right);
        if (diff > 1) {
            return -1;
        }
        
        return left > right? left + 1 : right + 1;
    }
}
