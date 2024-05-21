package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LeetCode0148 {
    public ListNode sortList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        nodes.sort((o1, o2) -> {
            if (o1.val < o2.val) {
                return -1;
            } else if (o1.val > o2.val) {
                return 1;
            }
            return 0;
        });
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (ListNode node : nodes) {
            cur.next = node;
            cur = cur.next;
            cur.next = null;
        }
        return dummy.next;
    }
}
