package com.algorithm.demo.huaWei;
import java.util.*;
/**
 * description
 *
 * @author qiDing
 * @date 2021-01-24 16:29
 */

public class 合并表记录{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int next = sc.nextInt();
            TreeMap<Integer,Integer> map = new TreeMap<>();
            for (int i = 0; i < next; i++) {
                int key = sc.nextInt();
                int value = sc.nextInt();
                if (map.containsKey(key)){
                    map.put(key,map.get(key)+value);
                }else {
                    map.put(key,value);
                }
            }
            map.entrySet().iterator().forEachRemaining(integerIntegerEntry -> {
                System.out.println(integerIntegerEntry.getKey()+" "+integerIntegerEntry.getValue());
            });
        }
    }
}
