package com.algorithm.demo.test;

import java.util.*;

/**
 * description
 *
 * @author qiDing
 * @date 2021-01-29 22:47
 */
public class Test {
    private static final Stack<String> stack1 = new Stack<String>();
    private static final Stack<String> stack2 = new Stack<String>();
    private static final List<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String str = scanner.nextLine();
            String[] ss = str.split(" ");
            for (int i = ss.length - 1; i >= 0; i--)
                stack1.push(ss[i]);
            ArrayList<Integer> integers = new ArrayList<>();
            Collections.sort(list);
            for (String s : list)
                System.out.println(s);
        }
    }

    public void test(String s, int point) {

    }


}
