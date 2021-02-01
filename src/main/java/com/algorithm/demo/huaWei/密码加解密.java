package com.algorithm.demo.huaWei;

/**
 * date: 2021-01-26 16:32
 * description
 *
 * @author qiDing
 */

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
//给定一个字符串数组。按照字典顺序进行从小到大的排序。

public class 密码加解密 {
    public static void main(String[] args) throws IOException {
        BufferedReader bt = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = bt.readLine()) != null) {
            String res = Encrypt(str);
            System.out.println(res);
            str = bt.readLine();
            String res2 = unEncrypt(str);
            System.out.println(res2);
        }
    }

    public static String Encrypt(String str) {
        char[] ch = str.toCharArray();
        char[] newch = new char[ch.length];
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (c >= 'a' && c < 'z')
                newch[i] = (char) (c - 31);
            if (c == 'z')
                newch[i] = 'A';
            if (c >= 'A' && c < 'Z')
                newch[i] = (char) (c + 33);//转换成小写
            if (c == 'Z')
                newch[i] = 'a';
            if (c >= '0' && c < '9')
                newch[i] = (char) (c + 1);
            if (c == '9')
                newch[i] = '0';

        }
        return String.valueOf(newch);

    }

    public static String unEncrypt(String str1) {
        char[] ch = str1.toCharArray();
        char[] newch = new char[ch.length];
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (c > 'a' && c <= 'z')
                newch[i] = (char) (c - 33);
            if (c == 'a')
                newch[i] = 'Z';
            if (c > 'A' && c <= 'Z')
                newch[i] = (char) (c + 31);//
            if (c == 'A')
                newch[i] = 'z';
            if (c > '0' && c <= '9')
                newch[i] = (char) (c - 1);
            if (c == '0')
                newch[i] = '9';

        }
        return String.valueOf(newch);

    }
}
