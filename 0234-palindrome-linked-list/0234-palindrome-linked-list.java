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
        if(head==null){
            return false;
        }
        if(head.next==null){
            return true;
        }
        ListNode curr=head;
        ListNode rev_head=null;

        while(curr!=null){
            ListNode temp=new ListNode(curr.val);
            temp.next=rev_head;
            rev_head=temp;
            curr=curr.next;
        }
        curr=head;
        while(curr!=null && rev_head!=null){
            if(curr.val!=rev_head.val){
                return false;
            }else{
                curr=curr.next;
                rev_head=rev_head.next;
            }
        }
        return true;
    }
}