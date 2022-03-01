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
    public ListNode reverseList(ListNode head) {
        ListNode iter = head;
        ListNode prev = null;
        while(iter!=null){
            ListNode next = iter.next;
            iter.next = prev;
            prev = iter;
            iter = next;
        }
        return prev;
    }
}