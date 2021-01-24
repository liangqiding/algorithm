package com.algorithm.demo.huaWei;

import java.util.Scanner;

/**
 * description:  方块从左上角走到右下角,求走法总数
 *
 * @author qiDing
 * @date 2021-01-24 11:36
 */
public class CubeToLeftOrRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println(test(x, y, 0));
    }

    public static int test(int x, int y, int sum) {
        if (x < 1 || y < 1) {
            return 0;
        }
        if (x == 1 || y == 1) {
            return sum + 1;
        }
        return test(x - 1, y, sum) + test(x, y - 1, sum);
    }
}
