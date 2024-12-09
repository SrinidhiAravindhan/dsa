public class Solution {
    
    // Helper method to find the first occurrence of the target
    private int findFirstPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                right = mid - 1; // Continue searching in the left half
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    
    // Helper method to find the last occurrence of the target
    private int findLastPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                left = mid + 1; // Continue searching in the right half
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        // Find the first position of the target
        int firstPos = findFirstPosition(nums, target);
        
        // If the target is not found, return [-1, -1]
        if (firstPos == -1) {
            return result;
        }
        
        // Find the last position of the target
        int lastPos = findLastPosition(nums, target);
        
        result[0] = firstPos;
        result[1] = lastPos;
        
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] result1 = sol.searchRange(nums1, target1);
        System.out.println("Output for [5,7,7,8,8,10], target=8: [" + result1[0] + ", " + result1[1] + "]");  // Output: [3,4]

        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = sol.searchRange(nums2, target2);
        System.out.println("Output for [5,7,7,8,8,10], target=6: [" + result2[0] + ", " + result2[1] + "]");  // Output: [-1,-1]

        int[] nums3 = {};
        int target3 = 0;
        int[] result3 = sol.searchRange(nums3, target3);
        System.out.println("Output for [], target=0: [" + result3[0] + ", " + result3[1] + "]");  // Output: [-1,-1]
    }
}
