import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort the array to handle duplicates easily
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // Found a valid combination
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates to avoid repeated combinations
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break; // No point in continuing further if the current candidate exceeds the target
            }

            // Choose the current number, and recursively explore with the updated target
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, current, result); // i + 1 because each number can be used only once
            current.remove(current.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] candidates1 = {10, 1, 2, 7, 6, 1, 5};
        int target1 = 8;
        System.out.println(solution.combinationSum2(candidates1, target1));

        // Test case 2
        int[] candidates2 = {2, 5, 2, 1, 2};
        int target2 = 5;
        System.out.println(solution.combinationSum2(candidates2, target2));
    }
}
