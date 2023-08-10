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
    public ListNode reverseKGroup(ListNode head, int k) {
     int i = 0;
        ListNode curr = head;
       while (i < k) {
            if (curr == null) {
                return head;
            }
            curr = curr.next;
            i++;
        }
        ListNode prev = head;
        ListNode nextN = head.next;
        for (i = 0; i < k - 1; i++) {
            ListNode b = nextN.next;
            nextN.next = head;
            head = nextN;
            nextN= b;
        }
        prev.next = reverseKGroup(curr, k);
        return head;
    }
}


        