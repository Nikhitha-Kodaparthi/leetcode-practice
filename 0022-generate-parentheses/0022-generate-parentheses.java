import java.util.*;

class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current,
                           int open, int close, int n) {

        // If the string is complete
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Add an opening parenthesis
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }

        // Add a closing parenthesis
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }
}