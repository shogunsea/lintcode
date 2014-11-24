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
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        // the idea is that: we want to figure out
        // maximal path sum in a tree, no matter where it starts
        // and ends. So for any tree node, it could form two types
        // of path, one is go from left child to right child, the other is 
        // go from one of the child and up to its parent node.
        // Both cases could form the maximal path. We update global sum
        // by comparing the two. The return value should be current node value
        // plus the bigger one from left or right child, which is the maximal
        // value this node can contribute.
        
        // as a pointer to result.
        int[] res = {root.val};
        dfsHelper(root, res);
        
        return res[0];
    }
    
    public int dfsHelper(TreeNode node, int[] res) {
        if (node == null) {
            return 0;
        }        
        
        int left = dfsHelper(node.left, res);
        int right = dfsHelper(node.right, res);
        
        int maxContribute = Math.max(node.val, Math.max(left + node.val, right + node.val));
        int crossSum = left + right + node.val;
        int localMax = Math.max(crossSum, maxContribute);
        res[0] = Math.max(res[0], localMax);
        return maxContribute;
    }
}


