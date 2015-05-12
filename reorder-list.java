public class Solution {
    public void reorderList(ListNode head) {
        // list of size 0, 1, 2 do not need to be modified.
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        
        // int len = 0;
        // ListNode lenRunner = head;
        // while (lenRunner != null) {
        //     len++;
        //     lenRunner = lenRunner.next;
        // }
        
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode secondHalf = slow.next;
        slow.next = null;
        
        ListNode pre = null;
        ListNode cur = secondHalf;
        
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        
        ListNode tailRunner = pre;
        ListNode headRunner = head;
        
        // if (len % 2 == 0) {
        
        // while (headRunner != null && tailRunner != null) {
        //     ListNode nextHead = headRunner.next;
        //     headRunner.next = tailRunner;
        //     headRunner = nextHead;
        //     ListNode nextTail = tailRunner.next;
        //     tailRunner.next = headRunner;
        //     tailRunner = nextTail;
        // }
        // } else {
        
        while (headRunner != null || tailRunner != null) {
            ListNode nextHead = headRunner.next;
            headRunner.next = tailRunner;
            headRunner = nextHead;
            if (tailRunner != null) {
                ListNode nextTail = tailRunner.next;
                tailRunner.next = headRunner;
                tailRunner = nextTail;
            }
        // }
        }
    }
}
        