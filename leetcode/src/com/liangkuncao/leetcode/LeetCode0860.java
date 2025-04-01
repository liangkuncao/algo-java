package com.liangkuncao.leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LeetCode0860 {
    public boolean lemonadeChange(int[] bills) {
        int price = 5;
        Change[] changeCount = new Change[3];
        changeCount[0] = new Change(20, 0);
        changeCount[1] = new Change(10, 0);
        changeCount[2] = new Change(5, 0);
        Map<Integer, Change> changeMap = new HashMap();
        for (Change change : changeCount) {
            changeMap.put(change.price, change);
        }

        for (int bill : bills) {
            changeMap.get(bill).count++;
            bill -= price;
            if (bill == 0) {
                continue;
            }
            for (Change change : changeCount) {
                int count = bill / change.price;
                if (change.count - count >= 0) {
                    change.count -= count;
                    bill -= count * change.price;
                }
            }
            if (bill > 0) {
                return false;
            }
        }
        return true;
    }

}
class Change {
    int price;
    int count;

    public Change(int price, int count) {
        this.price = price;
        this.count = count;
    }
}
