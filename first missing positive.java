public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Move each number to its correct position, if possible.
        for (int i = 0; i < n; i++) {
            // Only consider numbers in the range [1, n]
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1] to put nums[i] in its correct place.
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }

        // Step 2: Find the first index where nums[i] != i + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;  // The missing positive integer
            }
        }

        // Step 3: If all positions are correct, return n + 1
        return n + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 2, 0};
        System.out.println(solution.firstMissingPositive(nums1)); // Output: 3

        // Test case 2
        int[] nums2 = {3, 4, -1, 1};
        System.out.println(solution.firstMissingPositive(nums2)); // Output: 2

        // Test case 3
        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println(solution.firstMissingPositive(nums3)); // Output: 1
    }
}
