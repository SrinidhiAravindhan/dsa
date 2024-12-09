import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        // Create a stack to store opening brackets
        Stack<Character> stack = new Stack<>();
        
        // Traverse through each character in the string
        for (char c : s.toCharArray()) {
            // If the character is an opening bracket, push it onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // If the character is a closing bracket
            else {
                // If stack is empty or top of the stack doesn't match the current closing bracket
                if (stack.isEmpty()) {
                    return false; // No matching opening bracket
                }
                
                // Pop from the stack and check for the corresponding opening bracket
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false; // Mismatched brackets
                }
            }
        }
        
        // If the stack is empty, all brackets were matched, otherwise invalid
        return stack.isEmpty();
    }
}
