// in 12 mins. + in-order review.
// in 20 mins for Morris version.
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
 * Example of iterat a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class Solution {
    //@param root: The root of binary tree.
    Stack<TreeNode> st = new Stack<TreeNode>();
    TreeNode runner = null;
    
    public Solution(TreeNode root) {
        // write your code here
        runner = root;
        // st.push(root);
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return (!st.isEmpty() || runner != null);
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
        while (runner != null) {
            st.push(runner);
            runner = runner.left;
        }
        
        TreeNode res = st.pop();
        runner = res.right;
        return res;
    }
}


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
