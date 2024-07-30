package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode0141 {

    /**
     * 解法：快慢指针
     * 时间复杂度：O（N）
     * 空间复杂度：O（1）
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * solution: hash
     * time complexity: O(N)
     * space complexity: O(N)
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}


