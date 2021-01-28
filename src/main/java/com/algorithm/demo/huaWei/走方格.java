package com.algorithm.demo.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * date: 2021-01-26 15:24
 * description
 *
 * @author qiDing
 */
public class 走方格 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = bufferedReader.readLine()) != null && !"".equals(input)) {
            String[] s = input.trim().split(" ");
            int[] ints = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
            int test = test(ints[0], ints[1]);
            System.out.println(test);
        }
    }

    public static int test(int x, int y) {
        if (x == 0 || y == 0) {
            return 1;
        }
        return test(x - 1, y) + test(x, y - 1);
    }
}
