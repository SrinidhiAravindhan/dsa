import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Result list to store all the triplets
        List<List<Integer>> result = new ArrayList<>();
        
        // Edge case: If the array has less than 3 elements, return an empty list
        if (nums == null || nums.length < 3) {
            return result;
        }
        
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Step 2: Iterate through the array, using each element as the first element of the triplet
        for (int i = 0; i < nums.length - 2; i++) {
            // Avoid duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Set the two pointers: left and right
            int left = i + 1;
            int right = nums.length - 1;
            
            // Step 3: Use the two-pointer technique to find pairs that sum to -nums[i]
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for the second element (left)
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    
                    // Skip duplicates for the third element (right)
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    // Move both pointers
                    left++;
                    right--;
                } else if (sum < 0) {
                    // Move the left pointer to the right to increase the sum
                    left++;
                } else {
                    // Move the right pointer to the left to decrease the sum
                    right--;
                }
            }
        }
        
        return result;
    }
}
