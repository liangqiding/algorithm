package com.algorithm.demo.huaWei;

import java.util.Scanner;

/**
 * description  进制转换
 *
 * @author qiDing
 * @date 2021-01-24 15:33
 */
public class BaseConversion
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext())
        {
            String str = scanner.nextLine();
            System.out.println(Integer.valueOf(str.substring(2),16));
        }
    }
}