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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                // Create a dummy head node to simplify list construction
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        // Loop until both lists are exhausted AND there is no remaining carry
        while (l1 != null || l2 != null || carry != 0) {
            // Get the value of the current nodes; if a list is shorter, use 0
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // Calculate sum and update carry
            int sum = x + y + carry;
            carry = sum / 10;

            // Create a new node with the current digit and link it
            current.next = new ListNode(sum % 10);
            current = current.next;

            // Advance the pointers for the input lists
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Return the actual head of the sum list
        return dummyHead.next;
        
    }
}