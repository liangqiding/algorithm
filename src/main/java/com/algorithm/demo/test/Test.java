package com.algorithm.demo.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 2021-01-30 16:46
 * description
 *
 * @author qiDing
 */
public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine()) != null) {
            char[] chars = input.trim().toCharArray();
            // 区间开始坐标
            int point = 0;
            // 当前最长子串结束位置坐标
            int end = 0;
            // 区间数字总数
            int sum = 0;
            // 最长的区间数字总数
            int max = 0;
            String output = "";
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= '0' && chars[i] <= '9') {
                    if (i - end <= 1) {
                        end = i;
                        max++;
                        output += chars[i];
                    } else if (max < sum) {
                        output = input.substring(point, i);
                        max = sum;
                        end = i;
                        point = end;
                        sum = 0;
                    } else if (max == sum) {
                    } else {
                        point = i;
                        sum++;
                    }
                }
            }
        }
    }
}
