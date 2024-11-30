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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }

        // Calculate the size of the list
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        // Special case: if the first node needs to be removed
        if (size == n) {
            return head.next;
        }

        // Reset curr to head
        curr = head;

        // Traverse to the node just before the one to be removed
        for (int i = 1; i < size - n; i++) {
            curr = curr.next;
        }

        // Remove the nth node from the end
        curr.next = curr.next.next;

        // Return the updated list
        return head;
    }
}