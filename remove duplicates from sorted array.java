public class Solution {
    public int removeDuplicates(int[] nums) {
        // Edge case: if the array is empty, no unique elements
        if (nums.length == 0) {
            return 0;
        }

        // Pointer to track the position of the last unique element
        int i = 0;

        // Iterate over the array starting from the second element
        for (int j = 1; j < nums.length; j++) {
            // If we find a unique element (nums[j] != nums[i]), move the pointer i
            if (nums[j] != nums[i]) {
                i++;  // Move i to the next position
                nums[i] = nums[j];  // Update nums[i] with the unique element
            }
        }

        // Return the number of unique elements
        return i + 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test example 1
        int[] nums1 = {1, 1, 2};
        int k1 = sol.removeDuplicates(nums1);
        System.out.println("Output: " + k1);  // Expected: 2
        System.out.print("Modified Array: ");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " ");  // Expected: [1, 2]
        }
        System.out.println();

        // Test example 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = sol.removeDuplicates(nums2);
        System.out.println("Output: " + k2);  // Expected: 5
        System.out.print("Modified Array: ");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " ");  // Expected: [0, 1, 2, 3, 4]
        }
    }
}
