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
        if (head == null || head.next == null || k == 0) return head;
        int size=1;
        ListNode curr=head;
        while(curr.next!=null){
            size++;
            curr=curr.next;
        }
        curr.next=head;
        ListNode temp=head;
        k=k%size;
        int rem=size-k;//3
        for(int i=1;i<rem;i++){
            temp=temp.next;
        }
        ListNode prev=temp.next;
        temp.next=null;
        return prev;
    }
}