public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // DP table initialization
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Empty string and empty pattern match
        dp[0][0] = true;
        
        // Handle patterns like a*, a*b*, a*b*c*, etc.
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                
                if (pc == sc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // Match zero occurrences of the preceding character (dp[i][j - 2])
                    // or one or more occurrences of the preceding character (dp[i - 1][j] if characters match)
                    dp[i][j] = dp[i][j - 2] || (i > 0 && (sc == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                }
            }
        }
        
        return dp[m][n];
    }
}
