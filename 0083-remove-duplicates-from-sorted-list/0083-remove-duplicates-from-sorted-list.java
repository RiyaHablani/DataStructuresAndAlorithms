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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head; // List is empty or has only one node
        }

        ListNode curr = head; // Start with the head node

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                // Skip the duplicate node
                curr.next = curr.next.next;
            } else {
                // Move to the next distinct node
                curr = curr.next;
            }
        }

        return head;
    }
}