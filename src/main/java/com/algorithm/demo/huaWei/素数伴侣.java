package com.algorithm.demo.huaWei;

import java.util.Scanner;

/**
 * description
 *
 * @author qiDing
 * @date 2021-01-25 21:52
 */
public class 素数伴侣 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            int i = n * n * n;
            System.out.println(i);
            test(i);
        }
    }
    /**
     * 7833+7835+7837+7839+7841+7843+7845+7847+7849+7851+7853+7855+
     * 7857+7859+7861+7863+7865+7867+7869+7871+7873+7875+7877+7879+
     * 7881+7883+7885+7887+7889+7891+7893+7895+7897+7899+7901+7903+
     * 7905+7907+7909+7911+7913+7915+7917+7919+7921+7923+7925+7927+
     * 7929+7931+7933+7935+7937+7939+7941+7943+7945+7947+7949+7951+
     * 7953+7955+7957+7959+7961+7963+7965+7967+7969+7971+7973+7975+
     * 7977+7979+7981+7983+7985+7987+7989+7991+7993+7995+7997+7999+
     * 8001+8003+8005+8007+8009
     *
     * 3193+3195+3197+3199+3201+3203+3205+3207+3209+3211+3213+3215+3217+
     * 3219+3221+3223+3225+3227+3229+3231+3233+3235+3237+3239+3241+3243+
     * 3245+3247+3249+3251+3253+3255+3257+3259+3261+3263+3265+3267+3269+
     * 3271+3273+3275+3277+3279+3281+3283+3285+3287+3289+3291+3293+3295+
     * 3297+3299+3301+3303+3305
     */


    public static void test(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < n ; i += 2) {
            int sum = 0;
            for (int j = i ; j < n ; j += 2) {
                sum = sum + j;
                if (sum > n) {
                    break;
                }
                if (sum == n) {
                    while (j >= i) {
                       sb.append(i).append("+");
                        i += 2;
                    }
                    System.out.println(sb.substring(0,sb.length()-1));
                    sb.delete(0,sb.length());
                    return;
                }

            }
        }
    }
}
