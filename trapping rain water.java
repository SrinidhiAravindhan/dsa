public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        // Two pointers approach
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // Process the left pointer
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Update left max
                } else {
                    waterTrapped += leftMax - height[left]; // Water is trapped
                }
                left++;
            } else {
                // Process the right pointer
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Update right max
                } else {
                    waterTrapped += rightMax - height[right]; // Water is trapped
                }
                right--;
            }
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(height1));  // Output: 6

        // Test case 2
        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println(solution.trap(height2));  // Output: 9
    }
}
