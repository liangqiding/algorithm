package com.algorithm.demo.huaWei.migong;

/**
 * description
 *
 * @author qiDing
 * @date 2021-01-27 21:38
 */

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int a = str.indexOf(' ');
            int n = Integer.parseInt(str.substring(0, a));
            int m = Integer.parseInt(str.substring(a + 1));
            int[][] tab = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] nums = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    tab[i][j] = Integer.parseInt(nums[j]);
                }
            }
            String path = minpath("", tab, 0, 0);
            System.out.print(path);
        }
    }

    private static String minpath(String path, int[][] tab, int x, int y) {
        int n = tab.length;
        int m = tab[0].length;
        if (path.contains('(' + x + ',' + y + ")\n")) {
            return null;
        }
        path = path + '(' + x + ',' + y + ")\n";
        if (x == n - 1 && y == m - 1) {
            return path;
        }
        String temp1 = null, temp2 = null;
        if (x + 1 < n && tab[x + 1][y] == 0) {
            temp1 = minpath(path, tab, x + 1, y);
        }
        if (y + 1 < m && tab[x][y + 1] == 0) {
            temp2 = minpath(path, tab, x, y + 1);
        }


        if (temp1 == null && temp2 == null ) {
            return null;
        } else if (temp2 == null || (temp1 != null && temp1.length() <= temp2.length())) {
            return temp1;
        } else {
            return temp2;
        }
    }
}
