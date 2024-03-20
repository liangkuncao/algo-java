package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.ListNode;

public class LeetCode0092 {
    /**
     * 时间复杂度：0（N）
     * 空间复杂度：O（1）
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        ListNode prefix = null;
        ListNode suffix = null;
        int count = 0;
        ListNode start = null;
        while (cur != null) {
            if (count == left - 1) {
                prefix = cur;
                start = prefix.next;
            } else if (count == right) {
                suffix = cur.next;
                cur.next = null;
                break;
            }
            cur = cur.next;
            count++;
        }
        ListNode newStart = reverseSinglyLinkedList(start);
        prefix.next = newStart;
        start.next = suffix;
        return dummy.next;
    }

    private ListNode reverseSinglyLinkedList(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode next = node.next;
        ListNode newStart = reverseSinglyLinkedList(next);
        node.next = null;
        next.next = node;
        return newStart;
    }

    public static void main(String[] args) {
        ListNode start = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        start.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        LeetCode0092 leetCode0092 = new LeetCode0092();
//        while (start != null) {
//            System.out.println(start.val);
//            start = start.next;
//        }
        System.out.println("----");
        ListNode newStart = leetCode0092.reverseBetween(start, 2, 4);
        while (newStart != null) {
            System.out.println(newStart.val);
            newStart = newStart.next;
        }
    }
}
