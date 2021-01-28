package com.algorithm.demo.migong;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 * date: 2021-01-27 16:45
 * description
 *
 * @author qiDing
 */
public class Test {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("6666");
        stack.push("7777");
        System.out.println(JSON.toJSONString(stack));
        stack.pop();
        System.out.println(JSON.toJSONString(stack));

    }
}
