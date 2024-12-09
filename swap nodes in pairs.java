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
    public ListNode swapPairs(ListNode head) {
        // Create a dummy node to simplify edge cases (like an empty list or list with 1 element)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Traverse the list in pairs
        while (prev.next != null && prev.next.next != null) {
            // Initialize the two nodes to swap
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swap the nodes by changing their next pointers
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move the prev pointer two steps forward
            prev = first;
        }

        // Return the new head (dummy.next points to the new head after swap)
        return dummy.next;
    }

    // For testing locally (LeetCode handles input/output automatically)
    public static void main(String[] args) {
        // Example usage of the swapPairs function
        Solution sol = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode result = sol.swapPairs(head);

        // Print the swapped list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
