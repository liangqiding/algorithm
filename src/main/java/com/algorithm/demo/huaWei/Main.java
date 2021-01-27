package com.algorithm.demo.huaWei;

import java.util.Scanner;

/**
 * description
 *
 * @author qiDing
 * @date 2021-01-26 21:44
 */
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=reader.readLine())!=null){
            int max=0;
            char[] arr=str.toCharArray();
            for(int i=1;i<arr.length;i++){
                int left=i-1;
                int right=i;
                while(left>=0&&right<arr.length&&arr[left]==arr[right] ){
                    if(right-left+1>max){
                        max=right-left+1;
                    }
                    left--;
                    right++;
                }
                left=i-1;
                right=i+1;
                while(left>=0&&right<arr.length&&arr[left]==arr[right] ){
                    if(right-left+1>max){
                        max=right-left+1;
                    }
                    left--;
                    right++;
                }
            }
            System.out.println(max);
        }

    }

}