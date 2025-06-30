package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.ListNode;

public class LeetCode0445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLen(l1);
        int len2 = getLen(l2);
        ListNode head;
        if (len1 >= len2) {
            head = addTwoNumbers(l1, l2, len1 - len2);
        } else {
            head = addTwoNumbers(l2, l1, len2 - len1);
        }
        if (head.val >= 10) {
            ListNode newHead = new ListNode(1);
            head.val %= 10;
            newHead.next = head;
            return newHead;
        }
        return head;
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int more) {
        if (l1 == null) {
            return null;
        }

        if (more > 0) {
            l1.next = addTwoNumbers(l1.next, l2, more - 1);
        } else {
            l1.next = addTwoNumbers(l1.next, l2.next, more);
        }

        int a = l1.val;
        int b = more <= 0 ? l2.val : 0;
        int carry = 0;
        if (l1.next != null && l1.next.val >= 10) {
            carry = 1;
            l1.next.val %= 10;
        }
        l1.val = a + b + carry;
        return l1;
    }

    private int getLen(ListNode l1) {
        int result = 0;
        while (l1 != null) {
            result ++;
            l1 = l1.next;
        }
        return result;
    }
}
