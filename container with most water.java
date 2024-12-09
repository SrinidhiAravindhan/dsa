public class Solution {
    public int maxArea(int[] height) {
        int left = 0;         // Initialize left pointer
        int right = height.length - 1;  // Initialize right pointer
        int maxArea = 0;      // Variable to store the maximum area
        
        while (left < right) {
            // Calculate the area formed by the lines at left and right pointers
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int area = width * currentHeight;
            
            // Update maxArea if the current area is larger
            maxArea = Math.max(maxArea, area);
            
            // Move the pointer pointing to the shorter line inward
            if (height[left] < height[right]) {
                left++;   // Move left pointer to the right
            } else {
                right--;  // Move right pointer to the left
            }
        }
        
        return maxArea;  // Return the maximum area found
    }
}
