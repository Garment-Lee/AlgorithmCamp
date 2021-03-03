package com.ligf.algorithm.tree;

/**
 * @ClassName TreeNode
 * @Description 树数据结构节点
 * @Author Garment Lee
 * @Date 2021/2/24 0:48
 **/

public class TreeNode {

    /**
     * 左节点
     */
    public TreeNode left;

    /**
     * 右节点
     */
    public TreeNode right;

    /**
     * 节点的值
     */
    public int value;

    /**
     * 树节点的构造函数
     * @param val 传入节点的值
     */
    public TreeNode(int val){
        this.value = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
