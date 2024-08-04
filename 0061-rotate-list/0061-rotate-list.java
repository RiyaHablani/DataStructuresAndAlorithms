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
    public ListNode rotateRight(ListNode head, int k) {
       if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find the length of the list
        ListNode curr = head;
        int count = 1; // start from 1 since we are already at head node
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }

        // Make the list circular
        curr.next = head;

        // Calculate the effective number of rotations
        k = k % count;
        int rotate = count - k;

        // Find the new tail and new head
        curr = head;
        for (int i = 1; i < rotate; i++) {
            curr = curr.next;
        }
        ListNode newHead = curr.next;
        curr.next = null;

        return newHead;

    }
}