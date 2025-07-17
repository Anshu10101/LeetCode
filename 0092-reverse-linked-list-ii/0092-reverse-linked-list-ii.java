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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right)
            return head;

        // Step 1: Create dummy node to handle edge cases easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 2: Move `leftPrev` to one node before position `left`
        ListNode leftPrev = dummy;
        for (int i = 1; i < left; i++) {
            leftPrev = leftPrev.next;
        }

        // Start of the reversal segment
        ListNode current = leftPrev.next;

        // Step 3: Reverse the sublist from left to right
        ListNode prev = null;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        // Step 4: Reconnect the reversed part with the rest of the list
        leftPrev.next.next = current; // Connect tail of reversed sublist to node after `right`
        leftPrev.next = prev; // Connect node before `left` to the new head of reversed sublist

        return dummy.next; // Return the new head (may have changed if left == 1)
    }
}
