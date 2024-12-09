public class Solution {
    public void nextPermutation(int[] nums) {
        // Step 1: Find the largest index i such that nums[i] < nums[i + 1]
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        // If such index exists, find the largest index j such that nums[j] > nums[i]
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            
            // Step 2: Swap nums[i] and nums[j]
            swap(nums, i, j);
        }
        
        // Step 3: Reverse the sequence from nums[i + 1] to the end of the array
        reverse(nums, i + 1);
    }
    
    // Helper function to swap two elements in the array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    // Helper function to reverse the subarray nums[start] to nums[nums.length - 1]
    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        int[] nums1 = {1, 2, 3};
        sol.nextPermutation(nums1);
        System.out.println(Arrays.toString(nums1)); // Expected output: [1, 3, 2]

        int[] nums2 = {3, 2, 1};
        sol.nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2)); // Expected output: [1, 2, 3]

        int[] nums3 = {1, 1, 5};
        sol.nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3)); // Expected output: [1, 5, 1]
    }
}
