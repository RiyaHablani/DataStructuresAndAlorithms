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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;

        while(l1!=null && l2!=null){
            ListNode newNode=new ListNode();
            if(l1.val>=l2.val){
                newNode.val=l2.val;
                l2=l2.next;
            }else{
                newNode.val=l1.val;
                l1=l1.next;
            }
            curr.next=newNode;
            curr=curr.next;
        }
        
        while(l1!=null){
            curr.next=new ListNode(l1.val);
            curr=curr.next;
            l1=l1.next;
        }
        while(l2!=null){
            curr.next=new ListNode(l2.val);
            curr=curr.next;
            l2=l2.next;
        }
        return dummy.next;
    }
}