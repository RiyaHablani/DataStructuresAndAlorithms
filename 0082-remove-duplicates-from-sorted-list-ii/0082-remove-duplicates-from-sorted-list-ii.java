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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode first=dummy;
        ListNode curr=head;

        if(head==null || head.next==null){
            return head;
        }
        while(curr!=null && curr.next!=null){
            if(curr.val==curr.next.val){
                while(curr.next!=null && curr.val==curr.next.val){
                    curr=curr.next;
                }
                first.next=curr.next;
            }else{
                first=first.next;
            }
            curr=curr.next;
        }
        return dummy.next;
    }
}