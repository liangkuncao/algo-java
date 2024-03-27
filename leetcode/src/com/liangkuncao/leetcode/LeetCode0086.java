package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.ListNode;

import java.util.List;

public class LeetCode0086 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLess = new ListNode(-1);
        ListNode dummyGreater = new ListNode(-1);
        ListNode curLess = dummyLess;
        ListNode curGreater = dummyGreater;
        while (head != null) {
            if (head.val < x) {
                curLess.next = head;
                curLess = curLess.next;
            } else {
                curGreater.next = head;
                curGreater = curGreater.next;
            }
            head = head.next;
        }
        curGreater.next = null;
        curLess.next = dummyGreater.next;
        return dummyLess.next;
    }
}
