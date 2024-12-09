import java.util.*;
public class Main {
    public List<Boolean> isSpecialSubarray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] parity = new int[n - 1];

        // Step 1: Compute parity differences
        for (int i = 0; i < n - 1; i++) {
            parity[i] = (nums[i] % 2 != nums[i + 1] % 2) ? 1 : 0;
        }

        // Step 2: Compute prefix sum of parity differences
        int[] prefixSum = new int[n - 1];
        if (n > 1) {
            prefixSum[0] = parity[0];
            for (int i = 1; i < n - 1; i++) {
                prefixSum[i] = prefixSum[i - 1] + parity[i];
            }
        }

        // Step 3: Process queries
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            int from = query[0];
            int to = query[1];

            if (to - from <= 1) {
                // If subarray length is 1 or 2, it's always special
                result.add(true);
            } else {
                // Check for parity violations
                int violations = prefixSum[to - 1] - (from > 0 ? prefixSum[from - 1] : 0);
                result.add(violations == to - from - 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test inputs
        int[] nums = {4, 3, 1, 6};
        int[][] queries = {{0, 2}, {2, 3}};

        // Create an instance of the Solution class
        Main main = new Main();

        // Call the method and print the results
        List<Boolean> results = main.isSpecialSubarray(nums, queries);
        System.out.println(results); // Expected output: [false, true]
    }
}
