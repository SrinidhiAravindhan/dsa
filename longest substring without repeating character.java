public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;  // If the string is empty, return 0
        
        int maxLength = 0;  // To store the maximum length of the substring
        int left = 0;       // Left pointer of the sliding window
        Map<Character, Integer> map = new HashMap<>();  // Map to store the last seen index of characters
        
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            
            // If the character is already in the map and its last seen position is >= left, move left pointer
            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
                left = map.get(currentChar) + 1;  // Update left to exclude the previous occurrence of the character
            }
            
            // Update the map with the current character's last seen index
            map.put(currentChar, right);
            
            // Calculate the length of the current window and update the maxLength
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;  // Return the maximum length of substring without repeating characters
    }
}
