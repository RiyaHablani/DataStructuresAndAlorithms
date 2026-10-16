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
    public ListNode deleteMiddle(ListNode head) {
        ListNode curr=head;
        int size=0;
        while(curr!=null){
            size++;
            curr=curr.next;
        }
        curr=head;
        if(head==null || head.next==null){
            return null;
        }
        ListNode next=null;
        for(int i=1;i<size/2;i++){
            curr=curr.next;
        }
        curr.next=curr.next.next;
        return head;
    }
}