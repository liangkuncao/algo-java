package com.liangkuncao.leetcode;

public class LeetCode0492 {
    public int[] constructRectangle(int area) {
        int width = (int) Math.sqrt(area);
        int length = width + 1;
        int curArea = width;
        while (curArea != area) {
            if (curArea < area) {
                length++;
            } else {
                width--;
            }
            curArea = width * length;
        }
        return new int[]{length, width};
    }

    public int[] constructRectangle2(int area) {
        int width = (int) Math.sqrt(area);
        while (area % width != 0) {
            width--;
        }
        return new int[] {area / width, width};
    }
}
