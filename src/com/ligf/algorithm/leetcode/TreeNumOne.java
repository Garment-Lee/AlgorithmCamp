package com.ligf.algorithm.leetcode;

import com.ligf.algorithm.tree.TreeNode;

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

    /**
     * 判断树结构是否为平衡二叉树。
     * <p>解题思路: 因为要得到子树的高度，所以需要使用的是树的后序遍历。
     *  1) 在后序遍历的过程中，通过判断左右子树的高度差，如果高度差大于1，则表示该树不是平衡二叉树，返回值为-1；如果子树的值为-1，则返回该结点的高度也是-1，
     *     最后通过判断该树的高度是否为-1，来判断该树是否为平衡二叉树。
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int height = maxHeight(root);
        if (height == -1){
            return false;
        }
        return true;
    }

    /**
     * 后续遍历，得到树的高度。
     * 思路：通过递归方式后续遍历，在
     *      1）不需要传递递归参数；
     *      2）需要返回递归值，作为该树的高度；
     *      3）跳出递归循环条件：判断结点是否为null。
     * @param treeNode
     * @return
     */
    private int maxHeight(TreeNode treeNode){
        int height = 0;
        if (treeNode != null){
            int left = maxHeight(treeNode.getLeft());
            if (left == -1){
                return -1;
            }
            int right = maxHeight(treeNode.getRight());
            if (right == -1){
                return -1;
            }
            if (Math.abs(left - right) > 1){
                System.out.println("abnormal node:" + treeNode.getValue());
                return -1;
            } else {
                //正常返回树的高度
                height = Math.max(left, right) + 1;
            }
        }
        return height;
    }

}
