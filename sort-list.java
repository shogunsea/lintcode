/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        // Bottom up merge sort: sort 2, 4, 8, ..., nodes at a time.
        // When to terminate: record how many times the subroutine runs, 
        // at the finaly loop, it only runs one time: (len/4) * (2^2) = len, 
        // (len/2)*(2^1) = len.
        
        if (head == null || head.next == null) {
            // base case, 0 or 1 node: just return
            return head;
        }
        
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        // initial step: compare 2 nodes at a time.
        // each sublist length: 1
        int step = 1;
        
        while (true) {
            // each time start from head
            ListNode runner = dummy;
            int repeat = 0;
            
            // sort by 'step' nodes.
            while (runner != null) {
                runner = helper(runner, step);
                repeat++;
            }
            
            if (repeat == 1) {
                // final round
                break;
            }
            step *= 2;
        }
        
        return dummy.next;
    }
    
    public ListNode helper(ListNode head, int step) {
            // runner is one node before left.
            ListNode left = head.next;
            // one node before right
            ListNode rightTemp = left;
            int count = 0;
            while (count != step - 1 && rightTemp != null) {
                rightTemp = rightTemp.next;
                count++;
            }
            // rightTemp: one node before real right node.
            if (rightTemp == null || rightTemp.next == null) {
                // current list is shorter than 'step', no need 
                // to continue, return null
                head = null;
                return head;
            }
            // the real right
            ListNode right = rightTemp.next;
            // split left and right sublists
            rightTemp.next = null;
            
            // tail: one node before real tail node.
            ListNode tail = right;
            count = 0;
            while (tail != null && count != step - 1) {
                tail = tail.next;
                count++;
            }
            // split right list and tail
            // not return: tail can be null, or: right sublist 
            // can be empty.
            if (tail != null) {
                ListNode next = tail.next;
                tail.next = null;
                tail = next;
            }
            
            // merge left and right.
            // assign the last node after merging as new head.
            head = merge(head, left, right, tail);
            
            return head;
    }
    
    public ListNode merge(ListNode head, ListNode left, ListNode right, ListNode tail) {
        ListNode runner = head;
        while (left != null || right != null) {
            if (left == null) {
                runner.next = right;
                right = right.next;
            } else if (right == null) {
                runner.next = left;
                left = left.next;
            } else {
                if (left.val < right.val) {
                    runner.next = left;
                    left = left.next;
                } else {
                    runner.next = right;
                    right = right.next;
                }
            }
            runner = runner.next;
        }
        // runner now is the last node.
        runner.next = tail;
        return runner;
    }
}