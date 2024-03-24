package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode0082 {
    /**
     * 题型：单链表
     * 解法：遍历统计重复的值
     * 时间复杂度：O(N)，N是链表的长度，遍历的2便
     * 空间复杂度：O（N），N是重复的个数
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        Set<Integer> duplicate = new HashSet<>();
        ListNode cur = dummy.next;
        ListNode pre = dummy;
        while (cur != null) {
            if (cur.val == pre.val) {
                duplicate.add(cur.val);
            }
            pre = pre.next;
            cur = cur.next;
        }
        cur = dummy.next;
        pre = dummy;
        while (cur != null) {
            if (duplicate.contains(cur.val)) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 时间复杂度：O（N）
     * 空间复杂度：O（1）
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode();
        if (head == null) {
            return dummy.next;
        }

        ListNode pre = dummy;
        ListNode candidate = head;
        int count = 1;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == candidate.val) {
                count++;
            } else {
                if (count == 1) {
                    pre.next = candidate;
                    candidate.next = null;
                    pre = pre.next;
                }
                candidate = cur;
                count = 1;
            }
            cur = cur.next;
        }
        if (count == 1) {
            pre.next = candidate;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LeetCode0082 leetCode0082 = new LeetCode0082();
        ListNode dummy = new ListNode();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        dummy.next = node1;
        node1.next = node2;
        node2.next = node3;
        leetCode0082.deleteDuplicates2(dummy.next);


    }
}
