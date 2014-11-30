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
 */ 
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode pre = null;
        ListNode current = head;
        ListNode next = null;
        
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        
        return pre;
    }
}

