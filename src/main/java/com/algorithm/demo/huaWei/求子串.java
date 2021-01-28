package com.algorithm.demo.huaWei;

/**
 * date: 2021-01-26 13:07
 * description
 *
 * @author qiDing
 */

import com.alibaba.fastjson.JSON;

import java.io.*;

public class 求子串 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            if (str.equals("")) continue;
            int n = Integer.parseInt(str);
            int[] nums = new int[n];
            String[] str_heights = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(str_heights[i]);
            }
            test(nums, n);
        }
    }

    public static void test(int[] nums, int n) {
        int[] desc = new int[n];
        int[] asc = new int[n];
        for (int i = 0; i < n; i++) {
            desc[i] = 0;
            asc[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    desc[i] = Math.max(desc[i], desc[j] + 1);
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    asc[i] = Math.max(asc[i], asc[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < desc.length; i++) {
            int i1 = desc[i] + asc[i];
            if (i1 > max) {
                max = i1;
            }
        }
        System.out.println(n - max - 1);
    }
}