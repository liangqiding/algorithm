package com.algorithm.demo.test;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * date: 2021-01-27 13:10
 * description
 *
 * @author qiDing
 */
public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = bufferedReader.readLine()) != null) {
            int n = Integer.parseInt(input);
            String[] s = bufferedReader.readLine().trim().split(" ");
            int[] ints = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
            System.out.println(test(n, ints));
        }
    }

    public static int test(int n, int[] start) {
        int[] end = new int[start.length];
        for (int i = 0; i < n; i++) {
            end[i] = 1;
        }
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (start[i] > start[j]) {
                    end[i] = Math.max(end[i], end[j] + 1);
                    if (end[i]>max){
                        max=end[i];
                    }
                }
            }
        }
        return max;
    }
}
