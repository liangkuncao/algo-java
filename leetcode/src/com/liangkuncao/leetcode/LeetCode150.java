package com.liangkuncao.leetcode;

import java.util.Stack;

public class LeetCode150 {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                add(stack);
            } else if (token.equals("-")) {
                subtract(stack);
            } else if (token.equals("*")) {
                multiply(stack);
            } else if (token.equals("/")) {
                divide(stack);
            } else {
                stack.add(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private void add(Stack<String> stack) {
        int op1 = Integer.parseInt(stack.pop());
        int op2 = Integer.parseInt(stack.pop());
        int result = op2 + op1;
        stack.add(String.valueOf(result));
    }

    private void subtract(Stack<String> stack) {
        int op1 = Integer.parseInt(stack.pop());
        int op2 = Integer.parseInt(stack.pop());
        int result = op2 - op1;
        stack.add(String.valueOf(result));
    }

    private void multiply(Stack<String> stack) {
        int op1 = Integer.parseInt(stack.pop());
        int op2 = Integer.parseInt(stack.pop());
        int result = op2 * op1;
        stack.add(String.valueOf(result));
    }

    private void divide(Stack<String> stack) {
        int op1 = Integer.parseInt(stack.pop());
        int op2 = Integer.parseInt(stack.pop());
        int result = op2 / op1;
        stack.add(String.valueOf(result));
    }
}
