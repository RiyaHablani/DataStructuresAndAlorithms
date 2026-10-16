/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int counta=0,countb=0;
        ListNode curr1=headA,curr2=headB;
        while(curr1!=null){
            curr1=curr1.next;
            counta++;
        }
        while(curr2!=null){
            curr2=curr2.next;
            countb++;
        }
        curr1=headA;
        curr2=headB;
        while(counta>countb){
            curr1=curr1.next;
            counta--;
        }
        while(countb>counta){
            curr2=curr2.next;
            countb--;
        }
        while(curr1!=curr2){
            curr1=curr1.next;
            curr2=curr2.next;
        }
        return curr1;
    }
}