package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.ListNode;

public class LeetCode0092 {
    /**
     * 时间复杂度：0（N）
     * 空间复杂度：O（right - left），因为有递归
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

    /**
     * 题型：单向链表
     * 解法：模拟
     * 时间复杂度：O（N）
     * 空间复杂度：O（1）
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        ListNode succ = rightNode.next;
        ListNode leftNode = pre.next;
        pre.next = null;
        rightNode.next = null;
        reverseLinkedList(leftNode);
        pre.next = rightNode;
        leftNode.next = succ;
        return dummy.next;
    }

    private void reverseLinkedList(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
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
        ListNode newStart = leetCode0092.reverseBetween2(start, 2, 4);
        while (newStart != null) {
            System.out.println(newStart.val);
            newStart = newStart.next;
        }
    }
}
