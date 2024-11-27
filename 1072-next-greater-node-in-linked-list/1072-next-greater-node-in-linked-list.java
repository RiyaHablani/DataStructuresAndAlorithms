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
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        ListNode curr = head;
        int size = 0;

        // Calculate the size of the linked list.
        while (curr != null) {
            curr = curr.next;
            size++;
        }

        int[] arr = new int[size];
        int i = 0, j = 0;

        // Start with the head node for finding the next larger node.
        ListNode next = head;

        // Traverse the list.
        while (i < size && next != null) {
            ListNode temp = next.next; // Start checking from the next node.
            boolean found = false;

            // Find the next greater value.
            while (temp != null) {
                if (temp.val > next.val) {
                    arr[j] = temp.val;
                    found = true;
                    break;
                }
                temp = temp.next;
            }

            // If no greater value is found, set to 0.
            if (!found) {
                arr[j] = 0;
            }

            // Move to the next node.
            next = next.next;
            i++;
            j++;
        }

        return arr;
    }
}