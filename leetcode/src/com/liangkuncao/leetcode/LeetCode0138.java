package com.liangkuncao.leetcode;


import java.util.HashMap;
import java.util.Map;

public class LeetCode0138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(-1);
        Node cur = dummy;
        Node head2 = head;
        while (head != null) {
            Node copy = new Node(head.val);
            map.put(head, copy);
            cur.next = copy;
            head = head.next;
            cur = cur.next;
        }
        cur = dummy.next;
        while (head2 != null) {
            if (head2.random != null) {
                cur.random = map.get(head2.random);
            }
            cur = cur.next;
            head2 = head2.next;
        }
        return dummy.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
