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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        // recursion version.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        dfsHelper(res, root, 1);
        
        return res;
    }
    
    public void dfsHelper(ArrayList<ArrayList<Integer>> res, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        
        int size = res.size();
        ArrayList<Integer> currentLevel = null;
        
        if (size < level) {
            currentLevel = new ArrayList<Integer>();
            res.add(currentLevel);
        }  else {
            // index start from 0.
            currentLevel = res.get(level - 1);
        }
        
        currentLevel.add(node.val);
        
        dfsHelper(res, node.left, level + 1);
        dfsHelper(res, node.right, level + 1);
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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        // iterative version.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) {
            return res;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int size = 1;
        
        while (!queue.isEmpty()) {
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                tempList.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            
            size = queue.size();
            res.add(tempList);
        }
        
        return res;
    }
}






