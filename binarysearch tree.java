class Solution {
    public int numTrees(int n) {
        
        int[] dp = new int[n + 1];

        
        dp[0] = 1;
        dp[1] = 1;

        // Fill dp array for 2 to n nodes
        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                
                int leftSubtrees = dp[root - 1];
                int rightSubtrees = dp[nodes - root];
                dp[nodes] += leftSubtrees * rightSubtrees;
            }
        }

        return dp[n];
    }
}
