package com.algorithm.demo.huaWei;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * date: 2021-01-23 16:30
 * description 兄弟单词
 *
 * @author qiDing
 */
public class BrotherWords {

    /**
     * 先输入单词的个数n，再输入n个单词。
     * 再输入一个单词，为待查找的单词x
     * 最后输入数字k
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String[] arr = s.trim().split(" ");
        System.out.println(arr.length);
        int n = Integer.parseInt(arr[0]);
        TreeSet<String> set = new TreeSet<>();
        String x = arr[n + 1];
        System.out.println("x:"+x);
        int k = Integer.parseInt(arr[n + 2]);
        System.out.println("k:"+k);
        for (int i = 1; i < n; i++) {
            String t = arr[i];
            if (test(x, t)) {
                set.add(t);
            }
        }
        int i = 1;
        for (String next : set) {
            i++;
            System.out.println("i:"+i);
            if (i == k) {
                System.out.println(next);
            }
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
