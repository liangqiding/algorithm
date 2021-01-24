package com.algorithm.demo.huaWei;

import java.util.Scanner;

/**
 * description
 *
 * @author qiDing
 * @date 2021-01-24 17:15
 */
public class 提取不重复整数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        char[] chars= (num+"").toCharArray();
        String str ="";
        for(int i= chars.length-1; i>= 0;i--){
            if(!str.contains(chars[i]+"")){
                str +=chars[i];
            }
            if(str.length()>10){
                return;
            }
        }
        System.out.println(Integer.valueOf(str));
    }
}
