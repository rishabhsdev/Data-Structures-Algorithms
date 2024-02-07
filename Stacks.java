package DataStructures;

import java.util.Stack;

public class Stacks {

    private Stack<Character> stack = new Stack<>();

    public Boolean isBalanced(String expression) {
        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[' || ch == '<') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']' || ch == '>') {
                if (!match(ch)) {
                    return false;
                }
            }
        }

        return true;
    }

    public Boolean match(char ch) {
        switch (ch) {
            case ')':
                if (stack.peek() == '(') {
                    stack.pop();
                    return true;
                }
                return false;

            case '}':
                if (stack.peek() == '{') {
                    stack.pop();
                    return true;
                }
                return false;

            case ']':
                if (stack.peek() == '[') {
                    stack.pop();
                    return true;
                }
                return false;

            case '>':
                if (stack.peek() == '<') {
                    stack.pop();
                    return true;
                }
                return false;

            default:
                return false;
        }
    }
}
