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
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        // Find the length of the list and get the tail node
        ListNode current = head;
        int len = 1;
        while (current.next != null) {
            current = current.next;
            len++;
        }
        
        // Connect the tail to the head to make it a circular linked list
        current.next = head;
        
        // Find the new tail: (len - k % len) steps from the head
        k = k % len;
        int stepsToNewTail = len - k;
        ListNode newTail = current;
        
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }
        
        // Break the circle to get the new head
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }
}