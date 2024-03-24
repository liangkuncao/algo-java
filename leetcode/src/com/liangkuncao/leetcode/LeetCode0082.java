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
}
