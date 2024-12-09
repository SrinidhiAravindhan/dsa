public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Traverse through both lists
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;  // Move list1 pointer forward
            } else {
                current.next = list2;
                list2 = list2.next;  // Move list2 pointer forward
            }
            current = current.next;  // Move the current pointer forward
        }
        
        // At this point, at least one of the lists is null
        // If there are remaining nodes in list1, append them
        if (list1 != null) {
            current.next = list1;
        }
        
        // If there are remaining nodes in list2, append them
        if (list2 != null) {
            current.next = list2;
        }
        
        // Return the merged list starting from dummy.next
        return dummy.next;
    }
}
