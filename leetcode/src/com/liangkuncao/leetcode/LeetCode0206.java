package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.ListNode;

public class LeetCode0206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode nxt = head.next;
            head.next = pre;
            pre = head;
            head = nxt;
        }
        return pre;
    }
}
