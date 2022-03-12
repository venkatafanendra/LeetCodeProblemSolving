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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next == null)
            return true;
        boolean[] isodd = new boolean[1];
        ListNode middle = getMiddle(head,isodd);
        if(isodd[0]==true)
            middle=middle.next;
        ListNode second = reverse(middle);
        while(head!=null && second!=null){
            if(head.val!=second.val)
                return false;
            head=head.next;
            second=second.next;
        }
        return head==second?true:false;
    }
    private ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode current = head;
        while(current!=null){
            ListNode temp=current.next;
            current.next=prev;
            prev=current;
            current=temp;
        }
        return prev;
    }
    private ListNode getMiddle(ListNode head,boolean[] isodd){
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null)
            isodd[0]=true;
        prev.next=null;
        return slow;
    }
}