package com.algorithm.demo.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 2021-01-25 13:05
 * description
 *
 * @author qiDing
 */
public class 最小公倍数 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] strArr = str.split(" ");
            int x = Integer.parseInt(strArr[0]);
            int y = Integer.parseInt(strArr[1]);
            int j = y * x;
            if (x > y) {
                int temp = y;
                y = x;
                x = temp;
            }
            //最大公约数
            while (x != 0) {
                int r = y % x;
                y = x;
                x = r;
            }
            int max = j / y;
            System.out.println(max);
        }
    }
}