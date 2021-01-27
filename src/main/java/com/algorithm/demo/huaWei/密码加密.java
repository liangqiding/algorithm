package com.algorithm.demo.huaWei;

import java.util.Scanner;

/**
 * description
 *
 * @author qiDing
 * @date 2021-01-26 19:54
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 密码加密 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String key;
        while ((key = br.readLine()) != null) {
            char[] chars = key.toLowerCase().toCharArray();
            char[] dict = new char[26];
            int index = 0;
            tag1:
            for (char ch : chars) {
                for (int i = 0; i < index; i++) {
                    if (ch == dict[i]) {
                        continue tag1;
                    }
                }
                dict[index] = ch;
                index++;
            }

            char ch = 'a';
            tag2:
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < index; j++) {
                    if (dict[j] == ch) {
                        ch++;
                        continue tag2;
                    }
                }
                dict[index] = ch;
                ch++;
                index++;
            }

            String str = br.readLine();
            char[] res = str.toCharArray();
            for (int i = 0; i < res.length; i++) {
                if(res[i] - 'a'>=0){
                    res[i] = dict[res[i] - 'a'];
                }else{
                    res[i] = dict[res[i] - 'A'];
                }

            }

            System.out.println(String.valueOf(res));
        }
    }


}
