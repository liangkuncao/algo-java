package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = values.size() - 1;
        while (left < right) {
            if (!values.get(left).equals(values.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }

        int mid = length / 2;
        ListNode tail1 = head;
        for (int i = 0; i < mid - 1; i++) {
            tail1 = tail1.next;
        }
        ListNode head2 = tail1.next;
        tail1.next = null;
        head = reverse(head);
        if ((length & 1) == 1) {
            head2 = head2.next;
        }
        while (head != null) {
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        LeetCode0234 leetCode0234 = new LeetCode0234();
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        boolean result = leetCode0234.isPalindrome2(node1);
        System.out.println(result);
    }
}
