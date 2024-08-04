/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Insert copies of nodes in between original nodes
        Node temp = head;
        while (temp != null) {
            Node copy = new Node(temp.val);  // Corrected to use val instead of data
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next;
        }

        // Step 2: Assign random pointers for the copied nodes
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // Step 3: Separate the original and copied lists
        Node original = head, copyHead = head.next;
        Node copy = copyHead;
        while (original != null) {
            original.next = original.next.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            original = original.next;
            copy = copy.next;
        }

        return copyHead;
    }
}