package com.algorithm.demo.huaWei;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * description
 *
 * @author qiDing
 * @date 2021-01-24 17:25
 */
public class Test {

    public static void test1() {
        String res = "[A-Za-z]*";
        String b = "aasdasdasdA";
        boolean matches = b.matches(res);
        System.out.println(matches);
        char c = 'c';
        if ('A' < c && c > 'a')
            System.out.println("111111111");
    }


    public static void main(String[] args) throws IOException {

        System.out.println('a'-'A');
    }
}
