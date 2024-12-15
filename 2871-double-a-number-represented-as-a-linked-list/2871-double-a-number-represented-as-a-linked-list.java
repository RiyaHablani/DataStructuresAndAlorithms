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
    public ListNode reverseLinkedList(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public ListNode doubleIt(ListNode head) {
        ListNode newhead=reverseLinkedList(head);
        ListNode dummy=new ListNode(-1);
        ListNode ans=dummy;
        int carry=0;

        while(newhead!=null){
            int sum=newhead.val*2+carry;

            int digit=sum%10;
            carry=sum/10;

            ListNode temp=new ListNode(digit);
            dummy.next=temp;
            dummy=dummy.next;

            newhead=newhead.next;
        }
        if(carry>0){
            ListNode temp=new ListNode(carry);
            dummy.next=temp;
        }
        ans=reverseLinkedList(ans.next);
        return ans;
    }
}