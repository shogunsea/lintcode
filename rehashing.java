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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        int oldCap = hashTable.length;
        int newCap = oldCap * 2;
        ListNode[] rehashed = new ListNode[newCap];
        
        for (int i = 0; i < oldCap; i++) {
            ListNode cur = hashTable[i];
            if (cur != null) {
                ListNode runner = cur;
                while (runner != null) {
                    ListNode next = runner.next;
                    runner.next = null;
                    setNode(rehashed, runner);
                    runner = next;
                }
            }
        }
        
        return rehashed;
    }
    
    void setNode(ListNode[] table, ListNode elem) {
        int key = elem.val;
        int cap = table.length;
        int index;
        if (key < 0) {
            index = (key % cap + cap) % cap;
        } else {
            index = key % cap;
        }
        
        if (table[index] == null) {
            table[index] = elem;
        } else {
            ListNode runner = table[index];
            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = elem;
        }
    }
};

