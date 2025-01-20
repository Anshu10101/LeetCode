/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode firstHead, ListNode secondHead) {
        if (firstHead == null || secondHead == null)
            return null;

        ListNode temp1 = firstHead;
        ListNode temp2 = secondHead;

        while (temp1 != temp2) {
            temp1 = (temp1 == null) ? secondHead : temp1.next;
            temp2 = (temp2 == null) ? firstHead : temp2.next;
        }

        return temp1;
    }
}