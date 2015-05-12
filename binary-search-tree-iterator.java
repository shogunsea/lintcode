/// Morris traversal: O(1) space.
public class Solution {
    //@param root: The root of binary tree.
    TreeNode runner = null;
    
    public Solution(TreeNode root) {
        // write your code here
        runner = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        // using morris traversal we make sure
        // runner pointer will always not be null
        // untill traversal is done.
        return runner != null;
    }
    
    //@return: return next node
    public TreeNode next() {
        // first check left subtree, if null then we visit
        // current node and move to its right subtree.
        if (runner.left == null) {
            // visit runner
            TreeNode res = runner;
            runner = runner.right;
            return res;
        } else {
            // if left subtree not null, means we either
            // havent visit the substree or current node.
            // 
            // first while loop continues untill we find next
            // in-order element.
            while (runner.left != null) {
                // check whether predecessor's right pointer
                // points to current node.
                TreeNode pre = runner.left;
            
                while (pre.right != null && pre.right != runner) {
                    pre = pre.right;
                }
                
                if (pre.right == runner) {
                    // already visited left subtree. visit current node.
                    pre.right = null;
                    TreeNode res = runner;
                    runner = runner.right;
                    return res;
                } else {
                    // visit left subtree first.
                    pre.right = runner;
                    runner = runner.left;
                }
            }
            
            TreeNode res = runner;
            runner = runner.right;
            return res;
            
        }
    }

}