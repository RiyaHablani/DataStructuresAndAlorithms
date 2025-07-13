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

        // Map to store original node -> copied node
        Map<Node, Node> map = new HashMap<>();

        // Step 1: create copy nodes and store in map
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Step 2: assign next and random pointers
        curr = head;
        while (curr != null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);     // may be null
            copy.random = map.get(curr.random); // may be null
            curr = curr.next;
        }

        // Return head of copied list
        return map.get(head);
    }
}