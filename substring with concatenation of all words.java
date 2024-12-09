import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        
        // Create a frequency map for words in the list
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        
        // Sliding window approach
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            Map<String, Integer> windowMap = new HashMap<>();
            
            while (right + wordLen <= s.length()) {
                // Extract the current word
                String word = s.substring(right, right + wordLen);
                right += wordLen;
                
                // If the word is in the words list, update the window map
                if (wordCountMap.containsKey(word)) {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    
                    // If there are too many occurrences of the current word, move the left pointer
                    while (windowMap.get(word) > wordCountMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        left += wordLen;
                    }
                    
                    // If the window contains the exact number of words, add the index to the result
                    if (right - left == totalLen) {
                        result.add(left);
                    }
                } else {
                    // If the word is not in the list, reset the window
                    windowMap.clear();
                    left = right;
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test example 1
        String s1 = "barfoothefoobarman";
        String[] words1 = {"foo", "bar"};
        System.out.println(sol.findSubstring(s1, words1)); // Expected output: [0, 9]
        
        // Test example 2
        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = {"word", "good", "best", "word"};
        System.out.println(sol.findSubstring(s2, words2)); // Expected output: []

        // Test example 3
        String s3 = "barfoofoobarthefoobarman";
        String[] words3 = {"bar", "foo", "the"};
        System.out.println(sol.findSubstring(s3, words3)); // Expected output: [6, 9, 12]
    }
}
