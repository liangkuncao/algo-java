package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.ListNode;

public class LeetCode0019 {
    /**
     * 题型：单链表
     * 解法：遍历计算表的长度
     * 时间复杂度：O（N）
     * 空间复杂度：O（1）
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        int size = 0;
        ListNode cur = dummy;
        while (cur.next != null) {
            cur = cur.next;
            size++;
        }
        cur = dummy;
        for (int i = 0; i < size - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    /**
     * 解法：双指针
     * 时间复杂度：O（N）
     * 空间复杂度：O（1）
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
