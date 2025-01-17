class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        if(node == null)
            return node;
        // Traverse the list
        while (node != null && node.next != null) {
            // Check if current node's value is the same as next node's value
            if (node.val == node.next.val) {
                // Skip the next node
                node.next = node.next.next;
            } else {
                // Move to the next node
                node = node.next;
            }
        }
        
        return head;  // Return the modified list
    }
}
