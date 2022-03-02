/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    class NodeComparator implements Comparator<ListNode> {
        public int compare(ListNode l1,ListNode l2){
            if(l1.val>l2.val)
                return 1;
            else if(l1.val<l2.val)
                return -1;
            return 0;    
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new NodeComparator());
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
                minHeap.add(lists[i]);
        }
        if(minHeap.isEmpty())
            return null;
        ListNode head = new ListNode(0);
        ListNode handler = head;
        while(!minHeap.isEmpty()){
            ListNode curr = minHeap.poll();
            handler.next=curr;
            handler=handler.next;
            if(curr.next!=null){
                minHeap.add(curr.next);
            }
        }
        return head.next; 
    }
}