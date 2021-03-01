package com.ligf.algorithm.leetcode;

/**
 * @ClassName TreeNumOne
 * @Description 110. Balanced Binary
 * @Author Garment Lee
 * @Date 2021/3/1 23:30
 *
 * @ Title Description:
 * Given a binary tree, determine if it is height-balanced.For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 **/
public class TreeNumOne {

//    public boolean isBalanced(TreeNode root) {
//
//    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
