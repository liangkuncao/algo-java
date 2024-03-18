package com.liangkuncao.leetcode;

import java.util.Stack;

public class LeetCode150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> add(stack);
                case "-" -> subtract(stack);
                case "*" -> multiply(stack);
                case "/" -> divide(stack);
                default -> stack.add(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    private void add(Stack<Integer> stack) {
        int op1 = stack.pop();
        int op2 = stack.pop();
        int result = op2 + op1;
        stack.add(result);
    }

    private void subtract(Stack<Integer> stack) {
        int op1 = stack.pop();
        int op2 = stack.pop();
        int result = op2 - op1;
        stack.add(result);
    }

    private void multiply(Stack<Integer> stack) {
        int op1 = stack.pop();
        int op2 = stack.pop();
        int result = op2 * op1;
        stack.add(result);
    }

    private void divide(Stack<Integer> stack) {
        int op1 = stack.pop();
        int op2 = stack.pop();
        int result = op2 / op1;
        stack.add(result);
    }
}
