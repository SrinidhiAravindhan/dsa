public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0; // Pointer to keep track of the position for non-val elements

        // Iterate through the array
        for (int j = 0; j < nums.length; j++) {
            // If current element is not equal to val
            if (nums[j] != val) {
                nums[i] = nums[j]; // Move the non-val element to the front
                i++; // Increment the index of non-val elements
            }
        }

        // Return the number of elements that are not equal to val
        return i;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test example 1
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        int k1 = sol.removeElement(nums1, val1);
        System.out.println("Output: " + k1);  // Expected: 2
        System.out.print("Modified Array: ");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " ");  // Expected: [2, 2]
        }
        System.out.println();

        // Test example 2
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        int k2 = sol.removeElement(nums2, val2);
        System.out.println("Output: " + k2);  // Expected: 5
        System.out.print("Modified Array: ");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " ");  // Expected: [0, 1, 3, 0, 4]
        }
    }
}
