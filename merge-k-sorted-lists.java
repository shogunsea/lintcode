public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.size() == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue(lists.size(), new Comparator<ListNode>(){
            public int compare(ListNode node1, ListNode node2){
                return node1.val - node2.val;
            }
        });

        for(ListNode node : lists){
            if(node != null){
                queue.add(node);
            }
        }

        ListNode dummy = new ListNode(1);
        ListNode runner = dummy;

        while(!queue.isEmpty()){
            ListNode current = queue.poll();
            runner.next = current;
            runner = runner.next;
            current = current.next;
            
            while (!queue.isEmpty() && current != null && current.val <= queue.peek().val) {
                runner.next = current;
                runner = runner.next;
                current = current.next;
            }

            if(current != null){
                queue.add(current);
            }
        }

        return dummy.next;
    }
}

