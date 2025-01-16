class Solution {
    private ListNode tail; // Declare tail as a class-level variable.

    public ListNode reverseList(ListNode node) {
        if (node == null) { 
            return null; // Base case: if the list is empty, return null.
        }

        if (node.next == null) { 
            tail = node; // Initialize tail to the last node.
            return node; // Base case: return the last node as the new head.
        }

        ListNode head = reverseList(node.next); // Recur to reverse the rest of the list.

        tail.next = node; // Point the tail's next to the current node.
        tail = node; // Update tail to the current node.
        tail.next = null; // Set the current node's next to null.

        return head; // Return the new head of the reversed list.
    }
}
