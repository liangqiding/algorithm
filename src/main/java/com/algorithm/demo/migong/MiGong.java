package com.algorithm.demo.migong;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/**
 * date: 2021-01-27 15:43
 * description
 *
 * @author qiDing
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
    static Stack<String> minNodePath = new Stack<>();

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
            nodes.clear();
            minNodePath.clear();
            nodePath.clear();
            nodes.push(new Node(0, 0, 3, 1));
            test(n - 1, m - 1, tab);
            for (String o : minNodePath
            ) {
                System.out.println(o);
            }
        }
    }


    public static void test(int n, int m, int[][] tab) {
        // 栈中无元素 递归结束
        if (nodes.size() <= 0) {
            return;
        }
        // 出栈 深度优先遍历开始 （广度优先遍历更适合做这道题，我两种都写了）
        Node pop = nodes.pop();
        int x = pop.x;
        int y = pop.y;
        int sum = pop.sum;
        int flag = pop.flag;
        // 若回溯则释放已保存路径  释放大小=回溯的步长
        while (sum - 1 < nodePath.size()) {
            nodePath.pop();
        }
        // 判断是否死循环，因为前后左右都能走，所以要排除死循环可能，即绕圈走
        if (notHasPath(x, y)) {
            nodePath.push(pop.toString());
        }
        // 终点结束 记录最小路径
        if (x == n && y == m) {
            int min = minNodePath.size();
            int np = nodePath.size();
            if (min == 0 || np < min) {
                minNodePath = (Stack<String>) nodePath.clone();
            }
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

    /**
     * 判断路径是否已走过
     */

    public static boolean notHasPath(int x, int y) {
        if (nodePath.contains(Node.toString(x, y))) {
            return false;
        }
        return true;
    }

    /**
     * 定义一个节点
     */
    static class Node {
        // x y 坐标
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

        public static String toString(int x, int y) {
            return "(" + x + "," + y + ")";
        }
    }
}