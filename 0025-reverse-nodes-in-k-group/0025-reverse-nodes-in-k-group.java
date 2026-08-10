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
        // Check whether we have at least k nodes
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            // If fewer than k nodes are left,
            // don't reverse them
            if (curr == null) {
                return head;
            }
            curr = curr.next;
        }
        // 'curr' is now the first node of the next group
        // 'prev' will eventually become the end
        // of the reversed group
        ListNode prev = head;
        // Start reversing from the second node
        ListNode nextNode = head.next;
        // Reverse k nodes
        for (int i = 0; i < k - 1; i++) {
            // Save the next node before changing the link
            ListNode temp = nextNode.next;
            // Reverse the link
            nextNode.next = head;
            // Move head to the newly reversed node
            head = nextNode;
            // Move to the next node
            nextNode = temp;
        }
        // 'prev' is now the last node of the reversed group.
        // Connect it to the result of the next group.
        prev.next = reverseKGroup(curr, k);
        // 'head' is now the first node of the reversed group
        return head;
    }
}