package com.algorithm.demo.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 2021-01-26 14:58
 * description
 *
 * @author qiDing
 */
public class 回文子串{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String read = "";
        while ((read = bufferedReader.readLine()) != null) {
            System.out.println(test(read));
        }
    }

    public static int test(String read) {
        StringBuilder sb = new StringBuilder(read);
        StringBuilder re = sb.reverse();
        int length = read.length();
        int max = 0;
        for(int i = 0 ;i < length; i++){
            for(int j = i + 1; j < length; j++){
                if(read.contains(re.substring(i,j))){
                    if(j - i > max){
                        max = j - i;
                    }
                }
            }
        }
        return max;
    }
}
