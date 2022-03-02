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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode();
        ListNode curr = root;
        while(list1!=null && list2!=null){
            if(list1.val==list2.val){
                ListNode temp1= new ListNode(list1.val);
                ListNode temp2=new ListNode(list2.val);
                list1=list1.next;
                list2=list2.next;
                curr.next=temp1;
                curr = curr.next;
                curr.next=temp2;
                curr=curr.next;
            }
            else if(list1.val>list2.val){
                ListNode temp2=new ListNode(list2.val);
                list2=list2.next;
                curr.next=temp2;
                curr=curr.next;
            }
            else{
                ListNode temp1= new ListNode(list1.val);
                list1=list1.next;
                curr.next=temp1;
                curr=curr.next;
            }
        }
        while(list1!=null){
            ListNode temp1= new ListNode(list1.val);
                list1=list1.next;
                curr.next=temp1;
                curr=curr.next;
        }
        while(list2!=null){
            ListNode temp2=new ListNode(list2.val);
                list2=list2.next;
                curr.next=temp2;
                curr=curr.next;
        }
        return root.next;
    }
}