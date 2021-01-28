package com.algorithm.demo.test;

import java.util.Scanner;

/**
 * date: 2021-01-27 09:46
 * description
 *
 * @author qiDing
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextDouble()){
            double v = scanner.nextDouble();
            test(5,v,0);
        }


    }

    public static void test(int start, double m, double sum) {
        sum = sum + m / 2 + m;
        m = m / 2;
        start--;
        if (start == 0) {
            System.out.println(sum-m);
            System.out.println(m);
            return;
        }
        test(start, m, sum);
    }
}
