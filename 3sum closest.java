import java.util.*;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array to use two-pointer technique
        Arrays.sort(nums);
        
        // Initialize the result with a sum that is definitely not valid
        int closestSum = Integer.MAX_VALUE;
        
        // Loop through each element as the first element of the triplet
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements to avoid repeating triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Two pointers: one starts after the current element, the other at the end of the array
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                // Calculate the sum of the triplet
                int sum = nums[i] + nums[left] + nums[right];
                
                // If the sum is exactly the target, return the sum
                if (sum == target) {
                    return sum;
                }
                
                // Check if this sum is closer to the target
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
                
                // Move the pointers to find a closer sum
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        // Return the closest sum found
        return closestSum;
    }
}
