/**
 * Definition for singly-linked list.
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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(1);
        ListNode runner = dummy;
        int carry = 0;
        int cur = 0;
        
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur = carry + l2.val;
                carry = cur / 10;
                cur %= 10;
                l2 = l2.next;
            } else if (l2 == null) {
                cur = carry + l1.val;
                carry = cur / 10;
                cur %= 10;
                l1 = l1.next;                
            } else {
                cur = carry + l1.val + l2.val;
                carry = cur / 10;
                cur %= 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            
            runner.next = new ListNode(cur);
            runner = runner.next;
        }
        
        if (carry != 0) {
            runner.next = new ListNode(carry);
            // runner = runner.next;
        }
        
        return dummy.next;
    }
}
