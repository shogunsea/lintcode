/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        // O(n^2) solution. same as when input is an array.
        // compute the index and build the tree top down.
        // However if we use scan the list from head to end,
        // we essentially will have the results same as doing
        // inorder traversal, thus we can build the tree bottom up.
        // so we scan the list, before half the index we are building 
        // left subtree. the we'll have pointer to root node. continue
        // scan and we'll build the right substree. recursive pattern.
        if (head == null) {
            return null;
        }
        
        int len = 0;
        ListNode runner = head;
        
        while (runner != null) {
            runner = runner.next;
            len++;
        }
        
        ListNode[] pointer = {head};
        
        return bottomUpHelper(pointer, 0, len - 1);
    }
    
    public TreeNode bottomUpHelper(ListNode[] pointer, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = (start + end) / 2;
        TreeNode left = bottomUpHelper(pointer, start, mid - 1);
        TreeNode root = new TreeNode(pointer[0].val);
        pointer[0] = pointer[0].next;
        TreeNode right = bottomUpHelper(pointer, mid + 1, end);
        
        root.left = left;
        root.right = right;
        return root;
    }
}






