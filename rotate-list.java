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
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        
        int len = 0;
        ListNode runner = head;
        while (runner != null) {
            runner = runner.next;
            len++;
        }
        
        if (n % len == 0) {
            // no changes needed
            return head;
        }
        
        n %= len;
        
        int offset = len - n - 1;
        runner = head;
        while (offset != 0) {
            runner = runner.next;
            offset--;
        }
        
        ListNode newHead = runner.next;
        runner.next = null;
        ListNode tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        return newHead;
        
    }
}