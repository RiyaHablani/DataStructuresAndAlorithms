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
        if (head == null || head.next == null) {
            return true; // Empty list or single node is a palindrome
        }
        
        // Step 1: Find the middle of the list using slow and fast pointers
        ListNode slow = head, fast = head;
        
        // Move slow pointer one step and fast pointer two steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;
        
        // Step 3: Compare the first and second halves
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false; // If mismatch, not a palindrome
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return true; // If we reach here, it is a palindrome
    }
    
    // Helper function to reverse the list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev; // New head of the reversed list
    }
}