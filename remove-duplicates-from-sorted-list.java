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
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode current = head;
        ListNode runner;
        
        while (current != null) {
            runner = current.next;
            while (runner != null) {
                if (runner.val != current.val) {
                    break;
                }
                runner = runner.next;
            }
            current.next = runner;
            current = runner;
        }

        return head;
    }  
}
