package com.liangkuncao.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class LeetCode0208 {
}

class Trie {
    char character;
    Map<Character, Trie> children;
    boolean isEnd;

    public Trie(char character) {
        this.character = character;
        this.children = new HashMap<>();
        this.isEnd = false;
    }

    public Trie() {
        this.children = new HashMap<>();
        this.isEnd = false;
    }

    public void insert(String word) {
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.children.containsKey(ch)) {
                curr.children.put(ch, new Trie(ch));
            }
            curr = curr.children.get(ch);
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie curr = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!curr.children.containsKey(ch)) {
                return null;
            }
            curr = curr.children.get(ch);
        }
        return curr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trie)) return false;
        Trie trie = (Trie) o;
        return character == trie.character;
    }

    @Override
    public int hashCode() {
        return Objects.hash(character);
    }
}
