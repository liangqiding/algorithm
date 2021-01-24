package com.algorithm.demo.huaWei;

/**
 * description
 *
 * @author qiDing 质数因子
 * @date 2021-01-24 15:38
 */
import java.util.Scanner;
public class 质数因子 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        long num = Long.parseLong(scan.next());
        long k = (long) Math.sqrt(num);
        for (long i = 2; i <= k; i++) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        System.out.println(num == 1 ? "": num+" ");
    }

}
