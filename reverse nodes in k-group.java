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
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Base case: if the list is empty or k == 1, no need to reverse
        if (head == null || k == 1) {
            return head;
        }

        // Create a dummy node to simplify the code (acts as a previous node for the head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy; // The end of the previous reversed group

        while (head != null) {
            // Check if there are at least k nodes to reverse
            ListNode groupStart = head;
            ListNode groupEnd = head;
            for (int i = 1; i < k; i++) {
                groupEnd = groupEnd.next;
                if (groupEnd == null) {
                    return dummy.next; // Less than k nodes left, return as is
                }
            }
            
            // Store the next node to process
            ListNode nextGroupStart = groupEnd.next;
            
            // Reverse the current k-group
            ListNode prev = nextGroupStart;
            ListNode curr = groupStart;
            while (curr != nextGroupStart) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Connect the previous group to the reversed group
            prevGroupEnd.next = groupEnd;

            // Connect the reversed group to the next group
            groupStart.next = nextGroupStart;

            // Move prevGroupEnd to the end of the reversed group
            prevGroupEnd = groupStart;

            // Move the head pointer to the next group to process
            head = nextGroupStart;
        }

        return dummy.next;
    }

    // For testing locally (LeetCode handles input/output automatically)
    public static void main(String[] args) {
        // Example usage of the reverseKGroup function
        Solution sol = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 2;
        ListNode result = sol.reverseKGroup(head, k);

        // Print the reversed list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
