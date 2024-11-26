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
         // Count the size of the linked list
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        // If the head node needs to be removed
        if (n == size) {
            return head.next;
        }

        // Traverse to the node just before the target node
        ListNode prev = head;
        for (int i = 1; i < size - n; i++) {
            prev = prev.next;
        }

        // Adjust pointers to remove the nth node
        prev.next = prev.next.next;

        return head; // Return the updated head
    }
}