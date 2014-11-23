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
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        // the idea is that: first search for the target node, then check
        // its children, if no children then just remove current node, we also
        // have to keep pareant node.
        // If only one node, swap the value with child and remove child.
        // If two children, swap value with predecessor and call remove method
        // on predecessor.
        if (root == null) {
            return root;
        }
        // solution line number - 5: actual line number.
        // TreeNode a = null;
        // TreeNode b = a.left;
        
        TreeNode runner = root;
        TreeNode parent = null;
        
        while (runner != null && runner.val != value) {
            parent = runner;
            if (runner.val < value) {
                runner = runner.right;
            } else {
                runner = runner.left;
            }
        }
        
        if (runner == null) {
            // cannot find the target
            return root;
        }
        
        // runner now is the target node.
        // parent node is runner's parent.
        if (runner.left == null && runner.right == null) {
            if (parent == null) {
                // removing root.
                return null;
            }
            if (parent.left == runner) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (runner.left == null || runner.right == null) {
            if (parent == null) {
                // removing root that has one subtree
                root = runner.left == null? runner.right : runner.left;
            } else if (parent.left == runner) {
                parent.left = runner.left == null? runner.right : runner.left;
            } else {
                parent.right = runner.left == null? runner.right : runner.left;
            }
        } else {
            // has two children.
            TreeNode pre = runner.left;
            TreeNode preParent = null;
            
            while (pre.right != null) {
                preParent = pre;
                pre = pre.right;
            }
            
            // if preParent is null, parent is runner.
            runner.val = pre.val;
            
            if (pre.left == null) {
                if (preParent == null) {
                    runner.left = null;
                } else {
                    preParent.right = null;
                }
            } else {
                // predecessor has left substree.
                if (preParent == null) {
                    runner.left = pre.left;
                } else {
                    preParent.right = pre.left;
                }
            }
            
        }
        
        return root;
    }
    
   
}
