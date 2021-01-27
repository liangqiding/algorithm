package com.algorithm.demo.huaWei.migong;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * description
 *
 * @author qiDing
 * @date 2021-01-27 19:25
 */
public class MiGong {

    /**
     * 深度遍历缓存
     */
    static Stack<Node> nodes = new Stack<>();

    /**
     * 记录已走路径
     */
    static Stack<String> nodePath = new Stack<>();
    /**
     * 记录最小路径
     */
    static Object[] minNodePath = new Object[100];


    public static void main(String[] args) throws IOException {
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
            nodes.push(new Node(0, 0, 3, 1));
            test(n - 1, m - 1, tab);
            for (Object o:minNodePath
                 ) {
                System.out.println(o);
            }
        }
    }

    static boolean first = true;

    public static void test(int n, int m, int[][] tab) {
        if (nodes.size() <= 0) {
            return;
        }
        Node pop = nodes.pop();
        int x = pop.x;
        int y = pop.y;
        int sum = pop.sum;
        int flag = pop.flag;
        // 释放已保存路径
        while (sum - 1 < nodePath.size()) {
            nodePath.pop();
        }
        // 终点结束 记录路径
        if (notHasPath(x, y)) {
            nodePath.push(("(" + x + "," + y + ")"));
        }

        if (x == n && y == m) {
            if (first) {
                minNodePath = nodes.toArray();
                System.out.println("min:" + JSON.toJSONString(nodes.toArray()));
                first = false;
            } else if (nodePath.size() <= minNodePath.length) {
                minNodePath = nodes.toArray();
            }
            System.out.println("min:" + JSON.toJSONString(nodePath));
            System.out.println("nodePath2:" + JSON.toJSONString(minNodePath));
        }
        // 下
        if (flag != 3 && notHasPath(x, y - 1) && (y - 1) >= 0 && tab[x][y - 1] == 0) {
            Node node = new Node(x, y - 1, 1, sum + 1);
            nodes.push(node);
        }
        // 右
        if (flag != 4 && notHasPath(x + 1, y) && (x + 1) <= n && tab[x + 1][y] == 0) {
            Node node = new Node(x + 1, y, 2, sum + 1);
            nodes.push(node);
        }
        // 上
        if (flag != 1 && notHasPath(x, y + 1) && (y + 1) <= m && tab[x][y + 1] == 0) {
            Node node = new Node(x, y + 1, 3, sum + 1);
            nodes.push(node);
        }
        // 左
        if (flag != 2 && notHasPath(x - 1, y) && (x - 1) >= 0 && tab[x - 1][y] == 0) {
            Node node = new Node(x - 1, y, 4, sum + 1);
            nodes.push(node);
        }
        test(n, m, tab);
    }

    public static boolean notHasPath(int x, int y) {
        if (nodePath.contains("(" + x + "," + y + ")")) {
            return false;
        }
        return true;
    }

    static class Node {
        int x;
        int y;
        // 1上 2右  3下 4左
        int flag;
        // 当前已走步数
        int sum;

        public Node(int x, int y, int flag, int sum) {
            this.x = x;
            this.y = y;
            this.flag = flag;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
}
