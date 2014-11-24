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
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return res;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        int size = 1;
        
        
        // ****** Queue adding order and list adding order relation:****
        // Queue: Left, Right:
        //              level % 2 != 0:  list.add(0, val)
        // Queue: Right, Left:
        //              level % 2 != 0: list.add(val)
                
        while (!queue.isEmpty()) {
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            // odd level: add to last
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                if (level % 2 != 0) {
                    tempList.add(0, node.val);
                } else {
                    tempList.add(node.val);
                }
                
                if (node.left != null) {
                    queue.add(node.left);
                }
               
                if (node.right != null) {
                    queue.add(node.right);
                }
                 
            }
            
            res.add(tempList);
            size = queue.size();
            level++;
        }
        
        return res;
    }
}
