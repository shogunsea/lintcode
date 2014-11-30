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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            list.add(node.val);
            if (node.left != null) {
                st.push(node.left);
            }
            if (node.right != null) {
                st.push(node.right);
            }
        }
        
        ArrayList<Integer> post = new ArrayList<Integer>();
        for (int i = list.size() - 1; i >= 0; i--) {
            post.add(list.get(i));
        }
        return post;
    }
}
