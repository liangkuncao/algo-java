package com.liangkuncao.leetcode;

import java.util.Arrays;

public class LeetCode1041 {
    private static final int[] NORTH = new int[] {0, 1};
    private static final int[] EAST = new int[] {1, 0};
    private static final int[] SOUTH = new int[] {0, -1};
    private static final int[] WEST = new int[] {-1, 0};
    private static final int[][] DIRECTIONS = new int[][] {NORTH, EAST, SOUTH, WEST};
    public boolean isRobotBounded(String instructions) {
        int[] position = new int[] {0, 0};
        int direction = 0;
        for (char ch : instructions.toCharArray()) {
            if (ch == 'G') {
                position[0] += DIRECTIONS[direction][0];
                position[1] += DIRECTIONS[direction][1];
            } else if (ch == 'L') {
                direction = getNewDirection(direction -1);
            } else if (ch == 'R') {
                direction = getNewDirection(direction + 1);
            }
        }
        if (position[0] == 0 && position[1] == 0) {
            return true;
        } else if (direction == 0) {
            return true;
        }
        System.out.println(direction);
        System.out.println(Arrays.toString(position));
        return false;
    }

    private int getNewDirection(int direction) {
        if (direction == -1) {
            return 4;
        } else if (direction == 4) {
            return 0;
        }
        return direction;
    }
}
