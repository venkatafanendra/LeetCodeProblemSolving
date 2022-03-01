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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i = 1;
        ListNode prev = null;
        ListNode curr = head;
        ListNode beforeRev= null;
        ListNode firstRev=null;
        while(i < left){
            prev = curr;
            curr=curr.next;
            i++;
        }
        beforeRev = prev;
        firstRev = curr;
        while(i<=right){
           ListNode temp = curr.next;
           curr.next=prev;
           prev=curr;
           curr=temp;
           i++;
        }
        if(left>1){
            beforeRev.next = prev;
        }
        firstRev.next = curr;
        return (left==1) ? prev : head ;
    }
}