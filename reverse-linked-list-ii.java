/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
    	if (head == null) {
    		return head;
    	}

    	ListNode dummy = new ListNode(1);
    	dummy.next = head;

    	ListNode start = getNode(dummy, m - 1);
    	ListNode end = getNode(dummy, n);

    	reverse(start, end);

    	return dummy.next;
    }

    public ListNode getNode(ListNode node, int n) {
    	while (node != null && n != 0) {
    		node  = node.next;
    		n--;
    	}
    	return node;
    }

    public void reverse(ListNode start, ListNode end) {
    	ListNode next;
    	ListNode runner = start.next;
    	while (start.next != end) {
    		next = runner.next;
    		start.next = runner.next;
    		runner.next = end.next;
    		end.next = runner;
    		runner = next;
    	}
    }
}
