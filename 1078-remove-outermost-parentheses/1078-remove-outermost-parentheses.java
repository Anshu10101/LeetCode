class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0; // To track the depth of parentheses
        StringBuilder ans = new StringBuilder(); // To store the result

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') count--; // Decrease count when closing parenthesis is encountered
            if (count != 0) ans.append(s.charAt(i)); // Append to result if count is not zero
            if (s.charAt(i) == '(') count++; // Increase count when opening parenthesis is encountered
        }

        return ans.toString(); // Convert StringBuilder to String and return
    }
}
