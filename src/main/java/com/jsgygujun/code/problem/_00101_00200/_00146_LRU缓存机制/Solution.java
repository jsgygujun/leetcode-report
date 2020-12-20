package com.jsgygujun.code.problem._00101_00200._00146_LRU缓存机制;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存机制
 *
 * 题目：
 * 运用你所掌握的数据结构，设计和实现一个「 LRU (最近最少使用) 」缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量「capacity」初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *
 * 进阶：你是否可以在「O(1)」时间复杂度内完成这两种操作？
 *
 * @author GuJun
 * @date 2020/12/20
 */
public class Solution {
    static class LRUCache {
        // 实际索引Node节点的容器
        private Map<Integer, Node> map;
        // 容量
        private final int capacity;
        // 维护一个双向队列
        // head 和 tail 本身不存储有效节点，仅作为哨兵节点
        private Node head;
        private Node tail;

        // 内部存储节点
        static class Node {
            int key;
            int val;
            Node prev;
            Node next;
            public Node(int key, int val) {
                this.key = key;
                this.val = val;
                prev = null;
                next = null;
            }
            public Node() {
                prev = null;
                next = null;
            }
        }

        // 从双向链表中删除指定节点
        void removeNode(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        // 把指定节点加入到尾部
        void appendToTail(Node node) {
            Node prev = tail.prev;
            node.prev = prev;
            node.next = tail;
            prev.next = node;
            tail.prev = node;
        }

        // 从队首删除有效节点
        Node popFromHead() {
            Node node = head.next;
            removeNode(node);
            return node;
        }

        // 移动指定节点到队尾
        void moveToTail(Node node) {
            removeNode(node);
            appendToTail(node);
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<Integer, Node>(capacity);
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node != null) {
                moveToTail(node);
                return node.val;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                removeNode(node);
                Node newNode = new Node(key, value);
                appendToTail(newNode);
                map.put(key, newNode);
            } else {
                Node newNode = new Node(key, value);
                appendToTail(newNode);
                map.put(key, newNode);
                if (map.size() > capacity) {
                    Node oldNode = popFromHead();
                    map.remove(oldNode.key);
                }
            }
        }
    }

}
