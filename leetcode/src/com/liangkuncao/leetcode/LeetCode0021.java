package com.liangkuncao.leetcode;

/*
题型：链表
解决方案：迭代
时间复杂度：O(N+M)
空间复杂度：O(1)

其他方案：递归
 */
public class LeetCode0021 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null&& list2 != null) {
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





