public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder cur = new StringBuilder();

        for (char c : (path + "/").toCharArray()) {
            if (c == '/') {
                if (cur.toString().equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!cur.toString().isEmpty() && !cur.toString().equals(".")) {
                    stack.push(cur.toString());
                }
                cur = new StringBuilder();
            } else {
                cur.append(c);
            }
        }

        return "/" + String.join("/", stack);
    }
}