import java.util.*;

public class Solution {
    public List<String> letterCombinations(String digits) {
        // If digits is empty, return an empty list
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        
        // Mapping of digits to letters (as a String array)
        String[] digitToLetters = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        
        // List to store the result
        List<String> result = new ArrayList<>();
        
        // Start the backtracking process
        backtrack(digits, 0, new StringBuilder(), result, digitToLetters);
        
        return result;
    }
    
    private void backtrack(String digits, int index, StringBuilder current, List<String> result, String[] digitToLetters) {
        // Base case: if the current combination is of the same length as digits, add it to the result
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        // Get the letters corresponding to the current digit
        String letters = digitToLetters[digits.charAt(index) - '0'];
        
        // Try each letter corresponding to the current digit
        for (char letter : letters.toCharArray()) {
            current.append(letter);  // Add the current letter
            // Recurse for the next digit
            backtrack(digits, index + 1, current, result, digitToLetters);
            current.deleteCharAt(current.length() - 1);  // Backtrack (remove the last letter)
        }
    }
}
