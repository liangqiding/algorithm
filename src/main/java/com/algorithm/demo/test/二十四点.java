package com.algorithm.demo.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;


public class 二十四点 {

    static ArrayList<Stack<Integer>> all = new ArrayList<>();
    static Stack<Integer> integers = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine()) != null) {
            String[] s = input.trim().split(" ");
            int[] ints = new int[4];
            boolean flag = true;
            for (int i = 0; i < s.length; i++) {
                {
                    //J、Q、K 小写joker表示小王，大写JOKER表示大王
                    int num;
                    switch (s[i]) {
                        case "A":
                            num = 1;
                            break;
                        case "J":
                            num = 11;
                            break;
                        case "Q":
                            num = 12;
                            break;
                        case "K":
                            num = 13;
                            break;
                        case "joker":
                            num = -1;
                            break;
                        case "JOKER":
                            num = -1;
                            break;
                        default:
                            num = Integer.parseInt(s[i]);
                    }
                    if (num == -1) {
                        flag = false;
                        break;
                    }
                    ints[i] = num;
                }
            }
            method = "NONE";
            all.clear();
            integers.clear();
            if (flag) {
                test(ints, 0);
                for (int i = 0; i < all.size(); i++) {
                    Stack<Integer> c = all.get(i);
                    int[] start = new int[c.size()];
                    for (int j = 0; j < start.length; j++) {
                        start[j] = c.pop();
                    }
                    if (ds(start, start[0] + "", start[0], 0)) {
                        break;
                    }
                }
            } else {
                System.out.println("ERROR");
            }
            System.out.println(method.replace("11", "J")
                    .replace("12", "Q")
                    .replace("13", "k")
                    .replace("1", "A"));
            System.out.println();
        }
    }


    /**
     * 计算4个数的所有组合
     */
    public static void test(int[] ints, int point) {
        if (point == ints.length) {
            all.add((Stack<Integer>) integers.clone());
            return;
        }
        for (int anInt : ints) {
            if (!integers.contains(anInt)) {
                integers.push(anInt);
                test(ints, point + 1);
                integers.pop();
            }
        }
    }

    static String method;

    /**
     * 递归 乘除
     */
    public static boolean ds(int[] ints, String s, float sum, int point) {
        if (sum == 24 && point == 3) {
            method = s;
            return true;
        }
        point++;
        if (point > 3) {
            return false;
        }
        return ds(ints, s + "*" + ints[point], sum * ints[point], point)
                || ds(ints, s + "+" + ints[point], sum + ints[point], point)
                || ds(ints, s + "-" + ints[point], sum - ints[point], point)
                || ds(ints, ints[point] + "/" + s, ints[point] / sum, point)
                || ds(ints, s + "/" + ints[point], sum / ints[point], point);
    }
}
