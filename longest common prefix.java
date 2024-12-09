public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Edge case: If the array is empty, return an empty string
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start by assuming the first string is the common prefix
        String prefix = strs[0];

        // Iterate through the strings
        for (int i = 1; i < strs.length; i++) {
            // Compare the current string with the current prefix
            while (strs[i].indexOf(prefix) != 0) {
                // Shorten the prefix by removing the last character
                prefix = prefix.substring(0, prefix.length() - 1);

                // If there is no common prefix, return an empty string
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
