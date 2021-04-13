package stack;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.println(parser.isBalanced(in.next()));
        }
        in.close();
    }
}

class Parser {
    public boolean isBalanced(String in) {
        if (in.isEmpty()) {
            return true;
        }
        int len = in.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = in.charAt(i);
            // ({)} {()} ({()})
            if (c == '{') {
                if (i + 1 < len && in.charAt(i + 1) == '}') {
                    i++;
                } else {
                    stack.push(c);
                }
            } else if (c == '(') {
                if (i + 1 < len && in.charAt(i + 1) == ')') {
                    i++;
                } else {
                    stack.push(c);
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
