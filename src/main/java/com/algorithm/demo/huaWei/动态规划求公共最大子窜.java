package com.algorithm.demo.huaWei;

import java.util.Scanner;

/**
 * description
 *
 * @author qiDing
 * @date 2021-01-25 21:03
 */
public class 动态规划求公共最大子窜 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String one = scanner.nextLine();
        String two = scanner.nextLine();
        System.out.println(test(one, two));
    }

    public static int test(String one, String two) {
        int oz = one.length();
        int tz = two.length();
        int max = 0;
        int[][] arr = new int[oz][tz];
        for (int i = 0; i < oz; i++) {
            for (int j = 0; j < tz; j++) {
                if (one.charAt(i) == two.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        int sum = arr[i - 1][j - 1] + 1;
                        if (sum > max) {
                            max = sum;
                        }
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }else {
                    arr[i][j] =0;
                }
            }
        }
        return max;
    }
}
