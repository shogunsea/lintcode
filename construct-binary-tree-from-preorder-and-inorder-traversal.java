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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       // write your code here
        int len = inorder.length;
        
        return buildHelper(inorder, 0, len - 1, preorder, 0, len - 1);
    }
    
    public TreeNode buildHelper(int[] inorder, int iStart, int iEnd, 
        int[] preorder, int pStart, int pEnd) {
            if (iStart > iEnd) {
                return null;
            }
            if (iStart == iEnd) {
                return new TreeNode(inorder[iStart]);
            }
            
            int rootIndex = 0;
            int rootVal = preorder[pStart];
            
            for (int i = iStart; i <= iEnd; i++) {
                if (inorder[i] == rootVal) {
                    rootIndex = i;
                    break;
                }
            }
            
            TreeNode root = new TreeNode(rootVal);
            
            root.left = buildHelper(inorder, iStart, rootIndex - 1, preorder, pStart + 1, pStart + (rootIndex - iStart));
            root.right = buildHelper(inorder, rootIndex + 1, iEnd, preorder, pStart + (rootIndex - iStart) + 1, pEnd);
            
            return root;
        }
}
