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
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    // public TreeNode insertNode(TreeNode root, TreeNode node) {
    //     // write your code here
    //     if (root == null) {
    //     	return node;
    //     }
        
    //     insertHelper(root, node);
    //     return root;
    // }

    // public void insertHelper(TreeNode parent, TreeNode node) {
    // 	if (parent == null) return;
    // 	if (parent.val < node.val) {
    // 		if (parent.right == null) {
    // 			parent.right = node;
    // 		} else {
    // 			insertHelper(parent.right, node);
    // 		}
    // 	} else {
    // 		if (parent.left == null) {
    // 			parent.left = node;
    // 		} else {
    // 			insertHelper(parent.left, node);
    // 		}
    // 	}
    // }

    // public TreeNode insertNode(TreeNode root, TreeNode node) {
    //     // write your code here
    //     if (root == null) {
    //     	return node;
    //     }

    //     if (root.val < node.val) {
    //     	root.right = insertNode(root.right, node);
    //     } else {
    //     	root.left = insertNode(root.left, node);
    //     }

    //     return root;
    // }

    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
        	return node;
        }

        TreeNode runner = root;
        TreeNode parent = null;
        while (runner != null) {
        	parent = runner;
        	if (runner.val < node.val) {
        		runner = runner.right;
        	} else {
        		runner = runner.left;
        	}
        }

        // if (parent != null) {
        	if (parent.val < node.val) {
        		parent.right = node;
        	} else {
        		parent.left = node;
        	}
        // }

        return root;
    }
}

