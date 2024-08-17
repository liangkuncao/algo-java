package com.liangkuncao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode0146 {

}

/**
 * 题解：双向链表、哈希表
 * 时间复杂度：O（1）
 * 空间复杂度：O（N）
 */
class LRUCache {
    Map<Integer, DLinkedNode> map;
    int capacity;
    DLinkedNode head;
    DLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.setNext(tail);
        tail.setPrev(head);
    }

    public int get(int key) {
        System.out.println(key);
        DLinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToTail(node);
        return node.getValue();
    }

    private void moveToTail(DLinkedNode node) {
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        appendToTail(node);
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node == null) {
            if (map.size() == capacity) {
                int needRemoveKey = head.getNext().getKey();
                map.remove(needRemoveKey);
                head.getNext().getNext().setPrev(head);
                head.setNext(head.getNext().getNext());
            }
            map.put(key, new DLinkedNode(key, value));
            appendToTail(map.get(key));
        } else {
            map.get(key).setValue(value);
            moveToTail(map.get(key));
        }
    }

    private void appendToTail(DLinkedNode node) {
        tail.getPrev().setNext(node);
        node.setPrev(tail.getPrev());
        node.setNext(tail);
        tail.setPrev(node);
    }
}

class DLinkedNode {
    private DLinkedNode prev;
    private DLinkedNode next;
    private int key;
    private int value;
    public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public DLinkedNode() {

    }

    public DLinkedNode getPrev() {
        return prev;
    }

    public void setPrev(DLinkedNode prev) {
        this.prev = prev;
    }

    public DLinkedNode getNext() {
        return next;
    }

    public void setNext(DLinkedNode next) {
        this.next = next;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
