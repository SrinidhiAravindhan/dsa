import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);  // start with empty string, 0 open and close parentheses
        return result;
    }

    private void generate(List<String> result, String current, int open, int close, int n) {
        // If the current string is of length 2*n, it is a valid combination
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // If we can still add an opening parenthesis, add it and recurse
        if (open < n) {
            generate(result, current + "(", open + 1, close, n);
        }

        // If we can still add a closing parenthesis, add it and recurse
        if (close < open) {
            generate(result, current + ")", open, close + 1, n);
        }
    }
}
