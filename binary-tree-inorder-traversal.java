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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode runner = root;
        
        while (!st.isEmpty() || runner != null) {
            while (runner != null) {
                st.push(runner);
                runner = runner.left;
            } 
            runner = st.pop();
            list.add(runner.val);
            runner = runner.right;
        }
        
        return list;
        
    }
}


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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        
        // use Morris traversal to visit the entire tree.
        // the idea is that for each node we check if its predecessor has
        // right pointer to current node, if not it means that we havent 
        // visited the left subtree, then we construct a pointer from 
        // predecessor to current node which is the sucessor. If we found
        // predecessor of current node has a right pointer to current node, 
        // it means that we have visited the predecessor and left subtree ,
        // we just revert the pointer to null, and visit current node.
        TreeNode runner = root;
        
        while (runner != null) {
            // get predecessor, check its right pointer
            TreeNode pre = runner.left;
            
            while (pre != null && pre.right != null && pre.right != runner) {
                pre = pre.right;
            }
            
            if (pre == null) {
                // no predecessor, visit current node and move on to right 
                // subtree
                list.add(runner.val);
                runner = runner.right;
                continue;
            } 
            
            if (pre.right == null) {
                // haven't visited left subtree.
                pre.right = runner;
                runner = runner.left;
            } else if (pre.right == runner) {
                // visited left subtree, revert and visit right
                pre.right = null;
                list.add(runner.val);
                runner = runner.right;
            }
        }
        
        
        return list;
        
    }
}
