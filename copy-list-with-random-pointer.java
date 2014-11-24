/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        // Scan the list once, map all nodes into hashmap.
        // scan second time to update pointer.
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode runner = head;
        
        while (runner != null) {
            RandomListNode copy = new RandomListNode(runner.label);
            map.put(runner, copy);
            runner = runner.next;
        }
        
        runner = head;
        
        while (runner != null) {
            if (runner.next != null) {
                map.get(runner).next = map.get(runner.next);
            }
            if (runner.random != null) {
                map.get(runner).random = map.get(runner.random);
            }
            
            runner = runner.next;
        }
        
        return map.get(head);
    }
}




/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        // insert copied node right after original node, time O(n)
        // O(1) extra space.
        RandomListNode runner = head;
        // if (head == null) {
        //     return null;
        // }
        
        while (runner != null) {
            RandomListNode next = runner.next;
            RandomListNode copy = new RandomListNode(runner.label);
            runner.next = copy;
            copy.next = next;
            runner = next;
        }
        
        runner = head;
        
        while (runner != null) {
            RandomListNode copy = runner.next;
            RandomListNode next = copy.next;
            if (runner.random != null) {
                copy.random = runner.random.next;
            }
            runner = next;
        }
        
        RandomListNode copyHead = head.next;
        RandomListNode copyRunner = copyHead;
        runner = head;
        // seperate two interleaved lists.
        while ( runner != null) {
            runner.next = copyRunner.next;
            runner = runner.next;
            if (runner != null) {
                copyRunner.next = runner.next;
                copyRunner = copyRunner.next;
            }
        }
        
        return copyHead;
    }
}
