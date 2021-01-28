package com.algorithm.demo.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * date: 2021-01-28 10:14
 * description
 *
 * @author qiDing
 */
public class Main {

    static Stack<Node> stack = new Stack<Node>();

    static Stack<int[]> path = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 9;
        int m = 9;
        int[][] tab = new int[n][m];
        // 初始化数组
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] nums = str.split(" ");
            for (int j = 0; j < m; j++) {
                tab[i][j] = Integer.parseInt(nums[j]);
            }

        }


        test(9, tab);

    }

    /**
     * 遍历开始
     */

    public static void test(int n, int[][] tab) {
        // 栈中无元素时 遍历结束
        if (stack.size() <= 0) {
            return;
        }
        Node pop = stack.pop();
        int x = pop.x;
        int y = pop.y;
        int v = pop.v;
        int sum = pop.sum;

        // 回溯-路径恢复0
        while (sum + 1 < path.size()) {
            int[] pops = path.pop();
            int popX = pops[0];
            int popY = pops[1];
            tab[popX][popY] = 0;
        }
//        tab[x][y] = v;
        path.add(new int[]{x, y});
        // 若队列有值继续深入 获取下一个0节点 若不能继续，则认为此路不通，执行回溯
        if (tab[x][y]==0){

        }
    }

    /**
     * 深度遍历入栈
     */
    public static void pushStack(int x, int y, int sum, int[][] tab) {

        boolean[] booleans = new boolean[10];

        Arrays.fill(booleans, true);

        // 横
        for (int i = 0; i < 9; i++) {
            int num = tab[i][y];
            booleans[num] = false;
        }
        // 竖
        for (int i = 0; i < 9; i++) {
            int num = tab[x][i];
            booleans[num] = false;
        }

        for (int v = 1; v < booleans.length; v++) {
            if (booleans[v]) {
                tab[x][y] = v;
                Node node = new Node(x, y, v, sum + 1);
                stack.push(node);
                test(9, tab);
            }
        }
    }

    static class Node {
        int x;
        int y;
        int v;
        int sum;

        public Node(int x, int y, int v, int sum) {
            this.x = x;
            this.y = y;
            this.v = v;
            this.sum = sum;
        }
    }
}
