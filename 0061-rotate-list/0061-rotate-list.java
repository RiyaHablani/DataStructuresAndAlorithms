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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head; 
        }
        int size=1;
        ListNode curr=head;
        while(curr.next!=null){
            curr=curr.next;
            size++;
        }
        k=k%size;
        if (k == 0) {
            return head; // No rotation needed
        }
        curr.next=head;
        ListNode next=new ListNode();
        int i=0;
        while(i<size-k){
           curr=curr.next;
           i++;
        }
        next=curr.next;
        curr.next=null;
        return next;
    }
}