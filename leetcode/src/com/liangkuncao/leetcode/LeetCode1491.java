package com.liangkuncao.leetcode;

public class LeetCode1491 {
    public double average(int[] salaries) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int result = 0;
        for (int salary : salaries) {
            result += salary;
            System.out.println(result);
            if (salary < min) {
                min = salary;
            }
            if (salary > max) {
                max = salary;
            }
        }
        return (double) (result - min - max) / (salaries.length - 2);
    }
}
