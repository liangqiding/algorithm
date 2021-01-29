package com.algorithm.demo.migong;

import java.util.Scanner;

/**
 * date: 2021-01-28 16:42
 * description
 *
 * @author qiDing
 */
public class 链表 {

    private static Node head;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            // 节点数
            int n = Integer.parseInt(in.next());
            // 头节点
            int val = Integer.parseInt(in.next());
            head = new Node(val);
            for (int i = 1; i < n; i++) {
                // 尾
                val = Integer.parseInt(in.next());
                // 头节点
                int node = Integer.parseInt(in.next());
                setNode(node, val);
            }
            int del = Integer.parseInt(in.next());
            delNode(del);
            Node newN = head;
            while (newN != null) {
                System.out.print(newN.v + " ");
                newN = newN.next;
            }
            System.out.println();
        }
    }

    public static void delNode(int v) {
        Node top = head;
        while (top.next != null && top.next.v != v) {
            top = top.next;
        }
        if (top.next != null) {
            top.next = top.next.next;
        }
    }


    public static void setNode(int pre, int last) {
        Node top = head;
        while (top.v != pre) {
            top = top.next;
        }
        top.next = new Node(last, top.next);
    }

    // 构建节点

    static class Node {
        int v;
        Node next;

        public Node(int v) {
            this.v = v;
        }

        public Node(int v, Node next) {
            this.v = v;
            this.next = next;

        }

    }
}
