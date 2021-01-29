package com.algorithm.demo.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * description
 *
 * @author qiDing
 * @date 2021-01-24 16:02
 */
public class 近似值 {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            double number = in.nextDouble();
            System.out.println(Math.round(number));

            HashMap<String,Integer> map= new HashMap<String,Integer>();

        }

    /**
     * date: 2021-01-29 15:27
     * description
     *
     * @author qiDing
     */
    public static class 求最大公子串 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = "";
            while ((input = br.readLine()) != null) {
                String str2 = input;
                String str1 = br.readLine();
                String min;
                String max;
                if (str1.length() > str2.length()) {
                    max = str1;
                    min = str2;
                } else {
                    max = str2;
                    min = str1;
                }
                test(max, min);
            }
        }

        public static void test(String str1, String str2) {
            int[][] ints = new int[str1.length()][str2.length()];
            for (int i = 0; i < str1.length(); i++) {
                ints[i][0] = 0;
            }
            for (int i = 0; i < str2.length(); i++) {
                ints[0][i] = 0;
            }
            int max = 0;
            int point = 0;
            for (int i = 0; i < str1.length(); i++) {
                for (int j = 0; j < str2.length(); j++) {
                    if (str1.charAt(i) == str2.charAt(j)) {
                        int s = 0;
                        if (i == 0 || j == 0) {
                            s = 1;
                        } else {
                            s = ints[i - 1][j - 1] + 1;
                        }
                        ints[i][j] = s;
                        if (s >= max) {
                            if (s == max && point > j) {
                                point = j;
                            } else if (s != max) {
                                point = j;
                            }
                            max = s;
                        }
                    }
                }
            }
            System.out.println(str2.substring(point - max + 1, point + 1));
        }
    }

    /**
     * date: 2021-01-29 14:21
     * description
     *
     * @author qiDing
     */
    public static class 求最大连续和 {
        public static void main(String[] args) {
            int[] arr={-2,1,-3,4,-1,2};
            int i = maxSubString(arr, arr.length);
            System.out.println(i);
        }

        public static int maxSubString(int[] a, int n) {
            int start = a[n - 1];
            int all = a[n - 1];
            for (int i = n - 2; i >= 0; i--)
            {
                start = Math.max(a[i], a[i] + start);
                all = Math.max(start, all);
            }
            return all;
        }
    }

    public static class 精确计算器 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s1;
            while ((s1 = br.readLine()) != null) {
                String s2 = br.readLine();
                s1 = s1.trim();
                s2 = s2.trim();
                StringBuilder sb1 = new StringBuilder(s1);
                StringBuilder sb2 = new StringBuilder(s2);
                int len1 = sb1.length();
                int len2 = sb2.length();
                if (len1 > len2) {
                    for (int i = 0; i < len1 - len2; i++) {
                        sb2.insert(0, "0");
                    }
                } else {
                    for (int i = 0; i < len2 - len1; i++) {
                        sb1.insert(0, "0");
                    }
                }
                System.out.println(sb1);
                System.out.println(sb2);
                StringBuilder sb = new StringBuilder();
                int carry = 0;//表示进位
                for (int i = sb1.length() - 1; i >= 0; i--) {
                    int n1 = sb1.charAt(i) - '0';
                    int n2 = sb2.charAt(i) - '0';
                    int sum = n1 + n2 + carry;
                    carry = sum / 10;
                    sb.insert(0, sum % 10);
                    System.out.println(sb);
                }
                if (carry != 0) {
                    sb.insert(0, carry);
                }
                System.out.println(sb.toString());
            }
        }
    }

    /**
     * date: 2021-01-27 13:10
     * description
     *
     * @author qiDing
     */

    public static class 编辑距离{
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str1;
            while((str1=br.readLine())!=null){
                String str2 = br.readLine();
                System.out.println(stringDistance(str1.toCharArray(),str2.toCharArray()));
            }
        }
        private static int stringDistance(char[] a, char[] b) {
            int[][] len = new int[a.length + 1][b.length + 1];
            for (int i = 0; i < a.length + 1; i++) {
                len[i][0] = i;
            }
            for (int j = 0; j <b.length + 1; j++) {
                len[0][j] = j;
            }
            for (int i = 1; i < a.length + 1; i++) {
                for (int j = 1; j < b.length + 1; j++) {
                    if (a[i - 1] == b[j - 1]) {
                        len[i][j] = len[i - 1][j - 1];
                    } else {
                        len[i][j] = Math.min(Math.min(len[i - 1][j], len[i - 1][j - 1]), len[i][j - 1]) + 1;
                    }
                }
            }
            return len[a.length][b.length];
        }
    }
}
