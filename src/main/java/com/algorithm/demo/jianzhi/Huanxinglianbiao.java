package com.algorithm.demo.jianzhi;

/**
 * date: 2021-02-01 13:11
 * description
 *
 * @author qiDing
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Huanxinglianbiao {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1).next = new ListNode(2);
        boolean b = new Huanxinglianbiao().hasCycle(a);
        System.out.println(b);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
