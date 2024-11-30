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
       if(head == null)    return false;
        if(head.next == null)   return true;

        ListNode rev_head = null;
        ListNode ptr = head;

        while(ptr != null)
        {
            ListNode temp = new ListNode(ptr.val);
            temp.next = rev_head;
            rev_head = temp;
            ptr = ptr.next;
        }

        while(head != null && rev_head != null)
        {
            if(head.val != rev_head.val)    return false;
            else
            {
                head = head.next;
                rev_head = rev_head.next;
            }
        }
        return true;
        
    }
}