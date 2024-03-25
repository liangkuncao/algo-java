package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.ListNode;

public class LeetCode0061 {
    /**
     * 题型：单链表
     * 解法：计算表长度
     * 时间复杂度：O（N）
     * 空间复杂度：O（1）
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int size = 0;
        ListNode cur = head;
        ListNode tail = cur;
        while (cur != null) {
            tail = cur;
            size++;
            cur = cur.next;
        }
        k = k % size;
        if (k == 0) {
            return head;
        }
        int offset = size - k;
        ListNode newTail = head;
        while (offset > 1) {
            newTail = newTail.next;
            offset--;
        }
        ListNode newHead = newTail.next;

        newTail.next = null;
        tail.next = head;
        return newHead;
    }
}
