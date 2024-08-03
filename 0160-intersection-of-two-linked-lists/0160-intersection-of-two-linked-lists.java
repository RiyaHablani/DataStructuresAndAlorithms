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
        ListNode currA=headA,currB=headB;
        int count1=0,count2=0;
        while(currA!=null){
            currA=currA.next;
            count1++;
        }
        while(currB!=null){
            currB=currB.next;
            count2++;
        }
        currA = headA;
        currB = headB;

        int length = count1 - count2;
        if (length > 0) {
            while (length > 0) {
                currA = currA.next;
                length--;
            }
        } else {
            length = -length;
            while (length > 0) {
                currB = currB.next;
                length--;
            }
        }

        while (currA != null && currB != null) {
            if (currA == currB) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }

        return null;
    }
}