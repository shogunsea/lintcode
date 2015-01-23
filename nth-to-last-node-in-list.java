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
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if (head == null) {
        	return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (n != 0) {
        	fast = fast.next;
        	n--;
        }

        while (fast != null) {
        	fast = fast.next;
        	slow = slow.next;
        }

        return slow;
    }
}

