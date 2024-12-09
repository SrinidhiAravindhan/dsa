public class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        
        // Step 1: Build valid_pairs array to check adjacent pairs' parity
        boolean[] valid_pairs = new boolean[n - 1];
        
        for (int i = 0; i < n - 1; i++) {
            if ((nums[i] % 2) != (nums[i + 1] % 2)) {
                valid_pairs[i] = true; // Valid if different parity
            }
        }
        
        // Step 2: Build prefix_valid array to count valid pairs up to index i
        int[] prefix_valid = new int[n];
        for (int i = 1; i < n; i++) {
            prefix_valid[i] = prefix_valid[i - 1] + (valid_pairs[i - 1] ? 1 : 0);
        }
        
        // Step 3: Answer queries
        boolean[] result = new boolean[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int fromi = queries[i][0];
            int toi = queries[i][1];
            
            // If fromi == toi, it's trivially a valid subarray
            if (fromi == toi) {
                result[i] = true;
            } else {
                // Check if the number of valid pairs between fromi and toi is equal to the length of the subarray minus 1
                int valid_pair_count = prefix_valid[toi] - prefix_valid[fromi];
                if (valid_pair_count == (toi - fromi)) {
                    result[i] = true;
                } else {
                    result[i] = false;
                }
            }
        }
        
        return result;
    }
}

