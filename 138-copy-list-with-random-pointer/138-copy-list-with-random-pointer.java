/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Node curr = head;
        Node temp = null;
        while(curr!=null){
            temp = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next=temp;    
            curr = temp;
        }
        curr = head;
        while(curr!=null){
            curr.next.random = (curr.random!=null) ? curr.random.next : curr.random ;
            curr = curr.next.next;
        }
        curr = head;
        Node newHead = head.next;
        temp = newHead;
        while(curr!=null){
            curr.next = curr.next.next;
            temp.next = (temp.next!=null) ? temp.next.next : temp.next;
            curr = curr.next;
            temp=temp.next;
        }
        return newHead;
    }
}