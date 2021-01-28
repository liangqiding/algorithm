package com.algorithm.demo.test;

/**
 * date: 2021-01-27 11:02
 * description
 *
 * @author qiDing
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
*		现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
	每种砝码对应的数量为x1,x2,x3...xn。
	现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
		注：
	称重重量包括0
	方法原型：public static int fama(int n, int[] weight, int[] nums)
*/
public class Main2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1.高效读数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String mark = null;
        while ((mark = br.readLine()) != null) {
            int n = Integer.parseInt(mark);
            String[] s1 = br.readLine().split(" ");
            String[] s2 = br.readLine().split(" ");
            int[] weight = new int[s1.length];
            int[] nums = new int[s2.length];
            for (int i = 0; i < n; i++) {
                weight[i] = Integer.parseInt(s1[i]);
                nums[i] = Integer.parseInt(s2[i]);
            }
            System.out.println(fama(n, weight, nums));
        }
    }
    public static int fama(int n, int[] weight, int[] nums){
        int sum = 0;
        for(int i =0;i<n;i++){
            // 一共有多重
            sum = sum + nums[i]* weight[i];
        }
        boolean[] weg = new  boolean[sum+1];
        weg[0] =true;
        weg[sum] = true;
        // 三重循环，分别表示 n个砝码，weight.length 个种类，每个种类有 num.length 个数量
        for(int i =0; i< n; i++){
            for (int j = 0; j < nums[i]; j++) {
                for(int k=sum; k>= weight[i];k--){
                    // weg[k-weight[i]]== true,意思就是 k-weight[i] + weight[i] == k,可以称出 k 重量
                    if(weg[k -weight[i]]){
                        weg[k] = true;
                    }
                }
            }
        }
        int count = 0;
        for (boolean b : weg) {
            if (b) count++;
        }
        return count;
    }
}

