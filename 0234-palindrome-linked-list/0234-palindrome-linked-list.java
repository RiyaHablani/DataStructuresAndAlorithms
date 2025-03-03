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
        int size=0;
        ListNode curr=head;
        while(curr!=null){
            size++;
            curr=curr.next;
        }
        int mid=size/2;
        curr=head;
        for(int i=1;i<=mid;i++){
            curr=curr.next;
        }
        ListNode firstNode=head;
        ListNode secondNode=reverse(curr);

        while(secondNode!=null){
            if(firstNode.val!=secondNode.val){
                return false;
            }
            firstNode=firstNode.next;
            secondNode=secondNode.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
       ListNode curr=head;
       ListNode prev=null;
       ListNode next=null;
       while(curr!=null){
            next=curr.next;
            curr.next=prev;

            prev=curr;
            curr=next;
       }
       return prev;
    }
}