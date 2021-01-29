package com.algorithm.demo.test;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * date: 2021-01-29 16:02
 * description
 *
 * @author qiDing
 */
public class Test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine()) != null) {
            String[] s = input.trim().split(" ");
            int[] ints = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
            boolean test = false;
            to:
            for (int i = 0; i < ints.length; i++) {
                for (int j = i + 1; j < ints.length; j++) {
                    int pos = ints[i];
                    ints[i] = ints[j];
                    ints[j] = pos;
                    Node node = new Node(ints[0], 1);
                    if (test(node, ints)) {
                        System.out.println(JSON.toJSONString(ints));
                        test = true;
                        break to;
                    }
                }
            }
            System.out.println(test);
        }
    }

    public static boolean test(Node node, int[] ints) {
        if (node.sum == 24) {
            return true;
        }
        int sum = node.sum;
        int next = node.next;
        if (next >= ints.length) {
            return false;
        }
        System.out.println(node.sum+"---"+node.next);
        int b = ints[next];
        return test(new Node(sum + b, next + 1), ints)
                || test(new Node(sum * b, next + 1), ints)
                || test(new Node(sum - b, next + 1), ints)
                || test(new Node(sum / b, next + 1), ints);
    }

    static class Node {
        int sum;
        // 下个点
        int next;

        public Node(int sum, int next) {
            this.sum = sum;
            this.next = next;
        }
    }
}
