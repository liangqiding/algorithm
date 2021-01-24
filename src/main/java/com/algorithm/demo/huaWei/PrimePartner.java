package com.algorithm.demo.huaWei;

import java.util.Scanner;

/**
 * description 素数伴侣 java版本，也是匈牙利算法的思想
 *
 * @author qiDing
 * @date 2021-01-24 12:18
 */
public class PrimePartner {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNextInt()){
            int n=scan.nextInt();
            int m[]=new int[n];
            int jishu=0;
            for(int i=0;i<n;i++){
                m[i]=scan.nextInt();
                if(m[i]%2==1)jishu++;
            }
            int x[]=new int[jishu];
            int y[]=new int[n-jishu];
            int h=0;
            int z=0;
            for(int j=0;j<n;j++){
                if(m[j]%2==1){
                    x[h++]=m[j];
                }else{
                    y[z++]=m[j];
                }
            }
            int sum=0;
            int[][] xy =new int[jishu][n-jishu];
            for(int j=0;j<x.length;j++){
                for(int k=0;k<y.length;k++){
                    int friend=x[j]+y[k];
                    boolean flag=true;
                    for(int l=2;l<friend;l++){
                        if (friend % l == 0) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        xy[j][k]=1;
                    }
                }
            }
            boolean[] ycode =new boolean[n-jishu];
            int y_x[]=new int[n-jishu];
            for(int i=0;i<x.length;i++){
                if(find(xy,y,ycode,i,y_x)){
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }
    public static boolean find(int xy[][],int y[],boolean ycode[],int x,int y_x[]){
        for(int i=0;i<y.length;i++){
            if(!ycode[i]&&xy[x][i]==1){
                ycode[i]=true;
                if(y_x[i]==0||find(xy,y,ycode,y_x[i]-1,y_x)){
                    y_x[i]=x+1;
                    ycode[i]=false;
                    return true;
                }

            }
        }
        return false;
    }
}
