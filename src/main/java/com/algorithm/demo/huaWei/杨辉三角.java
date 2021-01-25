package com.algorithm.demo.huaWei;

/**
 * date: 2021-01-25 13:58
 * description
 *
 * @author qiDing
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 杨辉三角 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sc = "";
        while ((sc = br.readLine()) != null) {
            int count = Integer.parseInt(sc);
            String[] input = br.readLine().split(" ");
            int flag = Integer.parseInt(br.readLine());
            int[] ints = Arrays.stream(input).mapToInt(Integer::parseInt).sorted().toArray();

            if (flag != 1) {
                for (Integer i : ints) {
                    System.out.print(i + " ");
                }
                System.out.println();
            } else {
                for (int i = ints.length - 1; i >= 0; i--) {
                    System.out.print(ints[i] + " ");
                }
                System.out.println();
            }
        }
    }
}
