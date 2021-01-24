package com.algorithm.demo.huaWei;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * description 兄弟单词
 *
 * @author qiDing
 */
public class BrotherWords {

    /**
     * 前置条件：
     * 1.查找单词和比对单词相同
     * 2.查找单词和比对单词长度一致
     * 思路：以比对单词为模板字母，每次同时reacple一个字母再比对字符串长度
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String[] arr = s.trim().split(" ");
        int n = Integer.parseInt(arr[0]);
        ArrayList<String> list = new ArrayList<>();
        String x = arr[n + 1];
        int k = Integer.parseInt(arr[n + 2]);
        for (int i = 1; i <= n; i++) {
            String t = arr[i];
            if (test(x, t) && !x.equals(t)) {
                list.add(t);
            }
        }
        int i = 1;
        int size = list.size();
        System.out.println(size);
        Object[] objects = list.stream().sorted().toArray();
        for (Object next : objects) {
            if (i == k) {
                System.out.println(next);
            }
            i++;
        }
    }

    public static boolean test(String a, String b) {
        if (a.length() == b.length()) {
            String[] split = a.split("");
            for (int i = 0; i < split.length; i++) {
                if (a.replaceAll(split[i], "").length() != b.replaceAll(split[i], "").length()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
