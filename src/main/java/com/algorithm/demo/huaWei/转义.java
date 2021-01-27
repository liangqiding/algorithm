package com.algorithm.demo.huaWei;

import java.util.*;

//package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 转义 {

    public static void main(String[] args) throws IOException {

        fx();
    }


    //region 	74				参数解析

    private static void fx() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = bf.readLine()) != null) {
            StringBuffer sb = new StringBuffer();
            int len = 0;
            int quotaNum = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '\"') {
                    quotaNum++;
                    continue;
                }
                if (str.charAt(i) != ' ') {
                    sb.append(str.charAt(i));
                } else if (quotaNum % 2 == 0) {
                    sb.append('\n');
                    len++;
                } else {
                    sb.append(' ');
                }
            }
            System.out.println(len + 1);
            System.out.println(sb.toString());

        }
        bf.close();
    }


    //endregion

}

