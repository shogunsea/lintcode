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
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    // top-down recursion, balanced tree: O(n).
    // unbalanced tree: O(n^2)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == A || root == B) {
            return root;
        }

        boolean aInLeft = containsNode(root.left, A);
        boolean bInLeft = containsNode(root.left, B);

        if (aInLeft && !bInLeft || !aInLeft && bInLeft) {
            return root;
        }

        if (aInLeft) {
            return lowestCommonAncestor(root.left, A, B);
        } else {
            return lowestCommonAncestor(root.right, A, B);
        }

    }

    public boolean containsNode(TreeNode parent, TreeNode node) {
        if (parent == null) {
            return node == null;
        }

        if (parent == node) {
            return true;
        }

        return containsNode(parent.left, node) || containsNode(parent.right, node);
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
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    // bottom-up recursion: O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null) {
            return null;
        }    

        if (root == A || root == B) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        if (left != null && right != null) {
            return root;
        } 

        return left != null? left : right;
    }
}
