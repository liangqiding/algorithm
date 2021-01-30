package com.algorithm.demo.migong;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Stack;

/**
 * date: 2021-01-27 16:45
 * description
 *
 * @author qiDing
 */
public class Test {

    public static Stack<Integer> stack = new Stack<Integer>();
    public static void main(String[] args) {
        int shu[] = {1,2,3,4};
        f(shu,shu.length,0);
    }
    /**
     *
     * @param shu   待选择的数组
     * @param size  要选择多少个次
     * @param cur   当前选择的是第几次
     */
    private static void f(int[] shu, int size, int cur) {
        // TODO Auto-generated method stub
        if(cur == size) {
            System.out.println(stack);
            return;
        }

        for(int i=0;i<shu.length;i++) {
            if(!stack.contains(shu[i])) {
                stack.add(shu[i]);
                f(shu, size, cur+1);
                stack.pop();
            }

        }
    }

}
