package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.ListNode;

/*
题型：链表
解决方案：迭代
时间复杂度：O(N+M)
空间复杂度：O(1)

其他方案：递归
 */
public class LeetCode0021 {
    /**
     * 题型：表
     * 解法：迭代
     * 时间复杂度：O（N）
     * 空间复杂度：O（1）
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 == null) {
            cur.next = list2;
        } else {
            cur.next = list1;
        }

        return dummy.next;
    }

    /**
     * 解法：递归
     * 时间复杂度：O（N + M）
     * 空间复杂度：O（N + M）
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists_recursion(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val <= list2.val) {
            list1.next = mergeTwoLists_recursion(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists_recursion(list1, list2.next);
            return list2;
        }
    }

    /**
     * 解法：迭代
     * 时间复杂度：O（N）
     * 空间复杂度：O（1）
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 == null) {
            cur.next = list2;
        } else {
            cur.next = list1;
        }
        return dummy.next;
    }

    public ListNode mergeTwoLists20250409(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (list1 != null & list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 == null) {
            cur.next = list2;
        } else {
            cur.next = list1;
        }
        return dummy.next;
    }
}





