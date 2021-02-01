package com.algorithm.demo.jianzhi;

/**
 * date: 2021-02-01 13:26
 * description  比递归效率的方块覆盖
 *
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * @author qiDing
 */
public class FankuaiXinshilu {

    public int rectCover(int target) {
        if (target == 1 || target == 0 || target == 2) {
            return target;
        }
        int[] dp = new int[target + 1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <= target; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int i = new FankuaiXinshilu().rectCover(3);
        System.out.println(i);
    }

}