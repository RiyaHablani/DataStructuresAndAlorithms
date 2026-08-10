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
        // If list is empty, has only one node,
        // or k is 0, no rotation is needed
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        // Find the length and the last node
        int size = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }
        // If k is bigger than the size,
        // remove unnecessary full rotations
        k = k % size;
        // If k becomes 0, no rotation is needed
        if (k == 0) {
            return head;
        }
        // Connect the last node to the first node
        // This temporarily makes the list circular
        tail.next = head;
        // Find the new tail
        // We need to move size - k steps
        ListNode newTail = head;
        for (int i = 1; i < size - k; i++) {
            newTail = newTail.next;
        }
        // The node after newTail becomes the new head
        ListNode newHead = newTail.next;
        // Break the circular connection
        newTail.next = null;
        return newHead;
    }
}