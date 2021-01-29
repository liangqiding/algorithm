package com.algorithm.demo.huaWei.migong;

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
public class 数独 {

    static Stack<Node> stack = new Stack<Node>();

    static ArrayList<int[]> ints = new ArrayList<>();

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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tab[i][j] == 0) {
                    ints.add(new int[]{i, j});
                }
            }
        }
        int[] ints = 数独.ints.get(0);
        Node node = new Node(ints[0], ints[1], 0);
        dfs(node, tab);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(tab[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 遍历开始
     */

    public static void dfs(Node node, int[][] tab) {
        // 到底了 结束
//        System.out.println("dfs:" + stack.size() + "----" + ints.size());
        int point = node.point;
        int x = node.x;
        int y = node.y;
//        System.out.println(x + "::" + y);
        List<Integer> choose = getChoose(x, y, tab);
        // 回溯
        if (choose.size() <= 0 && point < ints.size() - 1) {
            // 不合格，回溯
            Node last = stack.pop();
            tab[last.x][last.y] = 0;
//            System.out.println("不合格，回溯:" + stack.size());
            return;
        }
        for (Integer num : choose
        ) {
            tab[x][y] = num;
            if (point + 1 >= ints.size() || stack.size() == ints.size()) {
//                System.out.println("end:" + stack.size());
                return;
            }
            int[] ints = 数独.ints.get(point + 1);
            Node next = new Node(ints[0], ints[1], point + 1);
            stack.push(next);
            dfs(next, tab);
        }
    }

    /**
     * 深度遍历入栈 选择
     */
    public static List<Integer> getChoose(int x, int y, int[][] tab) {
        List<Integer> choose = new ArrayList<>();
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
        // 获取当前所有选择
        for (int v = 1; v < booleans.length; v++) {
            if (booleans[v]) {
                choose.add(v);
            }
        }
        return choose;
    }

    static class Node {
        int x;
        int y;
        int point;

        public Node(int x, int y, int point) {
            this.x = x;
            this.y = y;
            this.point = point;
        }
    }
}
