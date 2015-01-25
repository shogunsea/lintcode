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
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int n) {
        // write your code here
        return helper(1, n);
    }
    
    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (start > end) {
            res.add(null);
            return res;
        }
        
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = helper(start, i - 1);
            List<TreeNode> rights = helper(i + 1, end);
            for (TreeNode l : lefts) {
                for (TreeNode r : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
