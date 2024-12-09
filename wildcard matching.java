public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // DP table where dp[i][j] means s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty string matches empty pattern
        dp[0][0] = true;
        
        // Fill in the first row for cases where pattern has stars
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        // Fill in the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char patternChar = p.charAt(j - 1);
                
                if (patternChar == '*') {
                    // '*' matches either no character (dp[i][j-1]) or one or more characters (dp[i-1][j])
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (patternChar == '?') {
                    // '?' matches exactly one character, so check dp[i-1][j-1]
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Regular character match
                    dp[i][j] = dp[i - 1][j - 1] && s.charAt(i - 1) == patternChar;
                }
            }
        }
        
        // The result is whether the whole string s matches the whole pattern p
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        System.out.println(solution.isMatch("aa", "a"));       // Output: false
        System.out.println(solution.isMatch("aa", "*"));       // Output: true
        System.out.println(solution.isMatch("cb", "?a"));      // Output: false
        System.out.println(solution.isMatch("adceb", "*a*b")); // Output: true
        System.out.println(solution.isMatch("acdcb", "a*c?b")); // Output: false
    }
}
