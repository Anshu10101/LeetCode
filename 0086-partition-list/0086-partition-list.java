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
    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode(Integer.MIN_VALUE);
        ListNode biggerHead = new ListNode(Integer.MIN_VALUE);

        ListNode smaller = smallerHead;
        ListNode bigger = biggerHead;

        while( head != null){
            if(head.val < x){
                smaller.next = head;
                smaller = smaller.next;
            } else{
                bigger.next = head; 
                bigger = bigger.next;
            }
            head = head.next;
        }
        smaller.next = biggerHead.next;
        bigger.next = null;
        return smallerHead.next;
    }
}