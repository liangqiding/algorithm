package com.algorithm.demo.migong;

import java.util.*;

/**
 * description
 *
 * @author qiDing
 * @date 2021-01-29 22:47
 */
public class 火车进出站 {

    private static final Stack<String> STACK1 = new Stack<String>();

    private static final Stack<String> STACK2 = new Stack<String>();

    private static final List<String> LIST = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String str = scanner.nextLine();
            String[] ss = str.trim().split(" ");
            for (int i = ss.length - 1; i >= 0; i--) {
                STACK1.push(ss[i]);
            }
           test("",0,ss.length);
            Collections.sort(LIST);
            for (String s : LIST)
                System.out.println(s.trim());
        }
    }

    public static void test(String s, int point,int sum) {
        if (point == sum) {
            LIST.add(s);
            return;
        }
        // s1 出站 或不出
        if (!STACK1.isEmpty()) {
            String pop = STACK1.pop();
            STACK2.push(pop);
            test(s, point,sum);
            // 不出栈情况 从新入栈
            STACK1.push(pop);
            STACK2.pop();
        }
        // s2 出站也可不出
        if (!STACK2.isEmpty()) {
            String pop = STACK2.pop();
            test(s + " " + pop, point + 1,sum);
            // 不出站情况，从新入栈
            STACK2.push(pop);
        }
    }

}
