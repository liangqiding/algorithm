package com.algorithm.demo.jianzhi;

import com.alibaba.fastjson.JSON;

import java.util.*;


/**
 * date: 2021-02-01 07:55
 * description
 *
 * @author qiDing
 */
public class Erchashuchongzu {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        ArrayList<Integer> preList = new ArrayList<>();
        ArrayList<Integer> inList = new ArrayList<>();

        for (int i = 0; i < pre.length; i++) {
            preList.add(pre[i]);
        }
        for (int i = 0; i < in.length; i++) {
            inList.add(in[i]);
        }

        return left(preList, inList);
    }

    public TreeNode left(ArrayList<Integer> pre, ArrayList<Integer> in) {
        int center = pre.get(0);
        TreeNode root = new TreeNode(center);
        int point = 0;
        for (int j = 1; j < in.size(); j++) {
            if (in.get(j) == center) {
                point = j;
            }
        }
        ArrayList<Integer> leftPre = new ArrayList<>();
        ArrayList<Integer> leftIn = new ArrayList<>();
        ArrayList<Integer> rightPre = new ArrayList<>();
        ArrayList<Integer> rightIn = new ArrayList<>();
        for (int i = 1; i <=point; i++) {
            leftPre.add(pre.get(i));
        }
        for (int i = 0; i <= point; i++) {
            leftIn.add(in.get(i));
        }
        // 右
        for (int i = point + 1; i < pre.size(); i++) {
            rightPre.add(pre.get(i));
        }
        for (int i = point + 1; i < pre.size(); i++) {
            rightIn.add(in.get(i));
        }
        System.out.println(
                "=====pre"+pre+"in"+in+
                "leftPre:" + JSON.toJSONString(leftPre) +
                "leftIn:" + JSON.toJSONString(leftIn)+
                "rightPre:" + JSON.toJSONString(rightPre) +
                "rightIn:" + JSON.toJSONString(rightIn)

        );
        if (!leftPre.isEmpty()) {
            root.left = left(leftPre, leftIn);
        }
        if (!rightPre.isEmpty()) {
            root.right = left(rightPre, rightIn);
        }
        return root;
    }


    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode treeNode = new Erchashuchongzu().reConstructBinaryTree(pre, in);
        println(treeNode);
    }

    public static void println(TreeNode treeNode) {
        System.out.println(treeNode.val);
        if (treeNode.left != null) {
            println(treeNode.left);
        }
        if (treeNode.right != null) {
            println(treeNode.right);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
}