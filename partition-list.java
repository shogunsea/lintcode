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
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null) {
            return head;
        }
        
        ListNode leftHead = new ListNode(0);
        ListNode rightHead = new ListNode(0);
        ListNode leftRunner = leftHead;
        ListNode rightRunner = rightHead;
        ListNode runner = head;
        ListNode next = null;
        
        while (runner != null) {
            next = runner.next;
            if (runner.val < x) {
                leftRunner.next = runner;
                leftRunner = leftRunner.next;
            } else {
                rightRunner.next = runner;
                rightRunner = rightRunner.next;
            }
            runner.next = null;
            runner = next;
        }
        
        leftRunner.next = rightHead.next;
        return leftHead.next;
    }
}

