public class Solution {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }

        // If the target is not found, `left` is the insert position
        return left;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1: target is found
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        System.out.println(sol.searchInsert(nums1, target1)); // Output: 2

        // Test case 2: target is not found, should be inserted at position 1
        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        System.out.println(sol.searchInsert(nums2, target2)); // Output: 1

        // Test case 3: target is not found, should be inserted at position 4
        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        System.out.println(sol.searchInsert(nums3, target3)); // Output: 4

        // Test case 4: target is smaller than all elements, should be inserted at position 0
        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;
        System.out.println(sol.searchInsert(nums4, target4)); // Output: 0
    }
}
