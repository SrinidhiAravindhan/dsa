public class Solution {
    public int strStr(String haystack, String needle) {
        // Use the built-in indexOf method to find the first occurrence of needle in haystack
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test example 1
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        int result1 = sol.strStr(haystack1, needle1);
        System.out.println(result1);  // Expected: 0
        
        // Test example 2
        String haystack2 = "leetcode";
        String needle2 = "leeto";
        int result2 = sol.strStr(haystack2, needle2);
        System.out.println(result2);  // Expected: -1
    }
}
