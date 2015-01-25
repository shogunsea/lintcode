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
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(1);
        ListNode runner = dummy;
        
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                runner.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                runner.next = l1;
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    runner.next = l1;
                    l1 = l1.next;
                } else {
                    runner.next = l2;
                    l2 = l2.next;
                }
            }
            
            runner = runner.next;
        }
        
        return dummy.next;
    }
}
