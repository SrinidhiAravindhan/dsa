public class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // To prevent overflow
            
            if (nums[mid] == target) {
                return mid; // Found the target
            }
            
            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                // Target is within the left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {
                // Target is within the right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1; // Target is not in the array
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        System.out.println(sol.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); // Output: 4
        System.out.println(sol.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)); // Output: -1
        System.out.println(sol.search(new int[]{1}, 0)); // Output: -1
    }
}
