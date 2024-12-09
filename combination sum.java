import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        // If the remaining target is 0, we've found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));  // Add a copy of the current combination
            return;
        }
        
        // If the remaining target is negative, no point in continuing
        if (target < 0) {
            return;
        }
        
        // Explore further by adding candidates starting from the 'start' index
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            // Recurse with the reduced target and current number still available
            backtrack(candidates, target - candidates[i], i, current, result);  // Notice we use 'i' and not 'i+1' for unlimited usage
            current.remove(current.size() - 1);  // Backtrack, remove the last added element
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println(solution.combinationSum(candidates1, target1));  // Output: [[2, 2, 3], [7]]
        
        // Test case 2
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println(solution.combinationSum(candidates2, target2));  // Output: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
        
        // Test case 3
        int[] candidates3 = {2};
        int target3 = 1;
        System.out.println(solution.combinationSum(candidates3, target3));  // Output: []
    }
}
