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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        int len = inorder.length;
        
        return buildHelper(inorder, 0, len - 1, postorder, 0, len - 1);
    }
    
    public TreeNode buildHelper(int[] inorder, int iStart, int iEnd, 
        int[] postorder, int pStart, int pEnd) {
            if (iStart > iEnd) {
                return null;
            }
            if (iStart == iEnd) {
                return new TreeNode(inorder[iStart]);
            }
            
            int rootIndex = 0;
            int rootVal = postorder[pEnd];
            
            for (int i = iStart; i <= iEnd; i++) {
                if (inorder[i] == rootVal) {
                    rootIndex = i;
                    break;
                }
            }
            
            TreeNode root = new TreeNode(rootVal);
            
            root.left = buildHelper(inorder, iStart, rootIndex - 1, postorder, pStart, pStart + (rootIndex - iStart - 1));
            root.right = buildHelper(inorder, rootIndex + 1, iEnd, postorder, pEnd - (iEnd - rootIndex),pEnd - 1);
            
            return root;
        }
}
