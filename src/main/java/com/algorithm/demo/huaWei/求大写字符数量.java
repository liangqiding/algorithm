package com.algorithm.demo.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 2021-01-26 14:50
 * description
 *
 * @author qiDing
 */
public class 求大写字符数量 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String read = "";
        while ((read = bufferedReader.readLine()) !=  null) {
            int test = test(read);
            System.out.println(test);
        }
    }

    public static int test(String t) {
        String res = "[A-Z]";
        String[] split = t.split("");
        int count = 0;
        for (String s : split
        ) {
            if (s.matches(res)) {
                count++;
            }
        }
        return count;
    }
}
